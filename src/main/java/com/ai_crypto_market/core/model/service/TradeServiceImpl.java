//package com.ai_crypto_market.core.model.service;
//
//import com.ai_crypto_market.core.model.entity.Position;
//import com.ai_crypto_market.core.model.entity.Stock;
//import com.ai_crypto_market.core.model.entity.Strategy;
//import com.ai_crypto_market.core.model.entity.Wallet;
//import com.ai_crypto_market.core.model.enums.ExchangeName;
//import com.ai_crypto_market.core.model.enums.StrategyType;
//import com.ai_crypto_market.core.model.enums.TradeAction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class TradeServiceImpl implements TradeService {
//
//    @Autowired
//    private PositionServiceImpl positionService;
//
//    @Autowired
//    private StockServiceImpl stockService;
//
//    @Autowired
//    private WalletServiceImpl walletService;
//
//    @Autowired
//    @Qualifier("ExchangeBingXService")
//    private ExchangeService exchangeBingXService;
//
//    @Autowired
//    @Qualifier("ExchangeBinanceService")
//    private ExchangeService exchangeBinanceService;
//    @Autowired
//    private PositionServiceImpl positionServiceImpl;
//
//    @Autowired
//    @Qualifier("signalServiceFibonacci")
//    private StrategyService strategyServiceFibonacci;
//
//    @Autowired
//    @Qualifier("signalServiceHoliday")
//    private StrategyService strategyServiceHoliday;
//
//
//    public void doTrade() {
//        List<Position> openPositions = positionService.getOpenPositions();
//        for (Position openedPosition : openPositions) {
//            ExchangeService exchangeService = exchangeFactory(openedPosition.getWallet().getExchange().getExchangeName());
//            openedPosition=exchangeService.getPositionInfoFromExchangeServiceApi(openedPosition);
//            Stock stock = stockService.getFullStockInfoFromExternalServiceApi(openedPosition.getStrategy().getStock());
//            openedPosition.getStrategy().setStock(stock);
//            // based on strategy name on openedPosition object we choose the related strategyService
//            Position afterAnalyzePosition = positionService.analyze(openedPosition);
//            // here we have a full object and new version of strategy object, which contains buy and sell percents
//            // todo save strategy, position object for ai purposes
//            switch (afterAnalyzePosition.getTradeAction()){
//                case TradeAction.BUY -> openedPosition = exchangeService.buy(openedPosition);
//                case TradeAction.CLOSE -> openedPosition = exchangeService.sell(openedPosition);
//                case TradeAction.CHANGETPSL -> openedPosition = positionService.changeTargetPriceAndStopLoss(openedPosition);
//            }
//        }
//
//        // بررسی موقعیت برای باز کردن پوزیشن جدید
//        // todo ولت های فعال، هر ولت چه استراتژی دارد و هر استراتژی موقعیت تمام استاک ها بررسی شود
//        List<Wallet> activeWallets = walletService.getAllActiveWalletOrderByCreatedAtDesc(); // آخرین ردیف ولت ها
//        for (Wallet wallet : activeWallets) {
//            List<Stock> stocks = stockService.findAllByStrategyIdOrderByCreatedAtDesc(wallet.getStrategy().getId()); // آخرین ردیف ولت ها
//            for (Stock stock : stocks) {
//                StrategyService strategyService = strategyFactory(wallet.getStrategy().getType());
//                ExchangeService exchangeService = exchangeFactory(wallet.getExchange().getExchangeName());
//                stock = stockService.getFullStockInfoFromExternalServiceApi(stock);
//                Position afterAnalyzePosition = strategyService.analyzeNew(stock);
//                if (Objects.requireNonNull(afterAnalyzePosition.getTradeAction()) == TradeAction.BUY) {
//                    afterAnalyzePosition = exchangeService.buy(afterAnalyzePosition);
//                }
//            }
//        }
//    }
//
//
//    private ExchangeService exchangeFactory(ExchangeName exchangeNameName) {
//        return switch (exchangeNameName) {
//            case BING_X -> exchangeBingXService;
//            case BINANCE -> exchangeBinanceService;
//            default -> null;
//        };
//    }
//
//    private StrategyService strategyFactory(StrategyType strategyType) {
//        return switch (strategyType) {
//            case FIBONACCI -> strategyServiceFibonacci;
//            case HOLIDAY -> strategyServiceHoliday;
//            default -> null;
//        };
//    }
//
//
//
//
//}


package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.common.factories.ExchangeFactory;
import com.ai_crypto_market.core.common.factories.StrategyFactory;
import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.Wallet;
import com.ai_crypto_market.core.model.enums.ExchangeName;
import com.ai_crypto_market.core.model.enums.TradeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TradeServiceImpl implements TradeService {

    private final PositionService positionService;
    private final StockService stockService;
    private final WalletService walletService;
    private final ExchangeFactory exchangeFactory;
    private final StrategyFactory strategyFactory;

    @Autowired
    public TradeServiceImpl(PositionService positionService,
                            StockService stockService,
                            WalletService walletService,
                            ExchangeFactory exchangeFactory,
                            StrategyFactory strategyFactory) {
        this.positionService = positionService;
        this.stockService = stockService;
        this.walletService = walletService;
        this.exchangeFactory = exchangeFactory;
        this.strategyFactory = strategyFactory;
    }

    @Override
    public void doTrade() {
        handleOpenPositions();
        handleNewOpportunities();
    }

    private void handleOpenPositions() {
        List<Position> openPositions = positionService.getOpenPositions();

        for (Position openedPosition : openPositions) {
            ExchangeName exchangeName = openedPosition.getWallet().getExchange().getExchangeName();
            ExchangeService exchangeService = exchangeFactory.getExchange(exchangeName);

            // Refresh position info from the exchange
            openedPosition = exchangeService.getPositionInfoFromExchangeServiceApi(openedPosition);

            // Enrich stock information
            Stock updatedStock = stockService.getFullStockInfoFromExternalServiceApi(openedPosition.getStrategy().getStock());
            openedPosition.getStrategy().setStock(updatedStock);

            // Analyze the position to determine the trade action
            Position analyzedPosition = positionService.analyze(openedPosition);

            // Execute the appropriate action based on the trade decision
            switch (analyzedPosition.getTradeAction()) {
                case BUY -> exchangeService.buy(analyzedPosition);
                case CLOSE -> exchangeService.sell(analyzedPosition);
                case CHANGETPSL -> positionService.changeTargetPriceAndStopLoss(analyzedPosition);
                default -> {
                    // Optional: Log unsupported or no-action cases here.
                }
            }
        }
    }

    private void handleNewOpportunities() {
        List<Wallet> activeWallets = walletService.getAllActiveWalletOrderByCreatedAtDesc();

        for (Wallet wallet : activeWallets) {
            ExchangeService exchangeService = exchangeFactory.getExchange(wallet.getExchange().getExchangeName());
            StrategyService strategyService = strategyFactory.getStrategy(wallet.getStrategy().getType());

            Set<Stock> stocks =  stockService.findAllByStrategyIdOrderByCreatedAtDesc(wallet.getStrategy().getId());
            for (Stock stock : stocks) {
                Stock fullStock = stockService.getFullStockInfoFromExternalServiceApi(stock);
                Position analyzedPosition = strategyService.analyzeNew(fullStock);
                if (TradeAction.BUY.equals(analyzedPosition.getTradeAction())) {
                    exchangeService.buy(analyzedPosition);
                }
            }
        }
    }
}