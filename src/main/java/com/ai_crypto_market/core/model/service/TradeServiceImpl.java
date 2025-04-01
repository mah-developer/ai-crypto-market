package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.Strategy;
import com.ai_crypto_market.core.model.entity.Wallet;
import com.ai_crypto_market.core.model.enums.ExchangeName;
import com.ai_crypto_market.core.model.enums.StrategyType;
import com.ai_crypto_market.core.model.enums.TradeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private PositionServiceImpl positionService;

    @Autowired
    private StockServiceImpl stockService;

    @Autowired
    private WalletServiceImpl walletService;

    @Autowired
    @Qualifier("ExchangeBingXService")
    private ExchangeService exchangeBingXService;

    @Autowired
    @Qualifier("ExchangeBinanceService")
    private ExchangeService exchangeBinanceService;
    @Autowired
    private PositionServiceImpl positionServiceImpl;

    @Autowired
    @Qualifier("signalServiceFibonacci")
    private StrategyService strategyServiceFibonacci;

    @Autowired
    @Qualifier("signalServiceHoliday")
    private StrategyService strategyServiceHoliday;


    public void doTrade() {
        List<Position> openPositions = positionService.getOpenPositions();
        for (Position openedPosition : openPositions) {
            ExchangeService exchangeService = exchangeFactory(openedPosition.getWallet().getExchange().getExchangeName());
            openedPosition=exchangeService.getPositionInfoFromExchangeServiceApi(openedPosition);
            Stock stock = stockService.getFullStockInfoFromExternalServiceApi(openedPosition.getStrategy().getStock());
            openedPosition.getStrategy().setStock(stock);
            // based on strategy name on openedPosition object we choose the related strategyService
            Position afterAnalyzePosition = positionService.analyze(openedPosition);
            // here we have a full object and new version of strategy object, which contains buy and sell percents
            // todo save strategy, position object for ai purposes
            switch (afterAnalyzePosition.getTradeAction()){
                case TradeAction.BUY -> openedPosition = exchangeService.buy(openedPosition);
                case TradeAction.CLOSE -> openedPosition = exchangeService.sell(openedPosition);
                case TradeAction.CHANGETPSL -> openedPosition = positionService.changeTargetPriceAndStopLoss(openedPosition);
            }
        }

        // بررسی موقعیت برای باز کردن پوزیشن جدید
        // todo ولت های فعال، هر ولت چه استراتژی دارد و هر استراتژی موقعیت تمام استاک ها بررسی شود
        List<Wallet> activeWallets = walletService.getAllActiveWalletOrderByCreatedAtDesc(); // آخرین ردیف ولت ها
        for (Wallet wallet : activeWallets) {
            List<Stock> stocks = stockService.findAllByStrategyIdOrderByCreatedAtDesc(wallet.getStrategy().getId()); // آخرین ردیف ولت ها
            for (Stock stock : stocks) {
                StrategyService strategyService = strategyFactory(wallet.getStrategy().getType());
                ExchangeService exchangeService = exchangeFactory(wallet.getExchange().getExchangeName());
                stock = stockService.getFullStockInfoFromExternalServiceApi(stock);
                Position afterAnalyzePosition = strategyService.analyzeNew(stock);
                if (Objects.requireNonNull(afterAnalyzePosition.getTradeAction()) == TradeAction.BUY) {
                    afterAnalyzePosition = exchangeService.buy(afterAnalyzePosition);
                }
            }
        }
    }


    private ExchangeService exchangeFactory(ExchangeName exchangeNameName) {
        return switch (exchangeNameName) {
            case BING_X -> exchangeBingXService;
            case BINANCE -> exchangeBinanceService;
            default -> null;
        };
    }

    private StrategyService strategyFactory(StrategyType strategyType) {
        return switch (strategyType) {
            case FIBONACCI -> strategyServiceFibonacci;
            case HOLIDAY -> strategyServiceHoliday;
            default -> null;
        };
    }




}
