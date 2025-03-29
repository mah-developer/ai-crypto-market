package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.Wallet;
import com.ai_crypto_market.core.model.enums.ExchangeName;
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
    @Qualifier("ExchangeBingXService")
    private ExchangeService exchangeBingXService;

    @Autowired
    @Qualifier("ExchangeBinanceService")
    private ExchangeService exchangeBinanceService;
    @Autowired
    private PositionServiceImpl positionServiceImpl;



    public void doTrade() {
        List<Position> openPositions = positionService.getOpenPositions();
        for (Position openedPosition : openPositions) {
            // fill ai news based it's service
            ExchangeService exchangeService = exchangeFactory(openedPosition.getWallet().getExchange().getExchangeName());

            // Long profit = exchangeService.getProfitFromExchangeServiceApi(openedPosition);
            // Long currentPrice = exchangeService.getPriceFromExchangeServiceApi(openedPosition);
            openedPosition=exchangeService.getPositionInfoFromExchangeServiceApi(openedPosition);

            //Stock stock = exchangeService.getFullStockInfoFromExchangeServiceApi(openedPosition.getStrategy().getStock());
            Stock stock = stockService.getFullStockInfoFromExternalServiceApi(openedPosition.getStrategy().getStock());

            // in other words we update the previous opened position
            openedPosition.getStrategy().setStock(stock);
            //openedPosition.setProfit(profit);
            //openedPosition.setCurrentPrice(currentPrice);
            // based on strategy name on openedPosition object we choose the related strategyService
            Position afterAnalyzePosition = positionService.analyze(openedPosition);

            // here we have a full object and new version of strategy object, which contains buy and sell percents
            // todo save strategy, position object for ai purposes
            switch (afterAnalyzePosition.getTradeAction()){
                case TradeAction.BUY -> openedPosition = exchangeService.buy(openedPosition);
                case TradeAction.CLOSE -> openedPosition = exchangeService.sell(openedPosition);
                case TradeAction.CHANGETPSL -> openedPosition = positionService.changeTargetPriceAndStopLoss(openedPosition);
            }
            // end each open position

        }


        // بررسی موقعیت برای باز کردن پوزیشن جدید
        // todo ولت های فعال، هر ولت چه استراتژی دارد و هر استراتژی موقعیت تمام استاک ها بررسی شود

//        List<Wallet> activeWallets = walletService.getActiveWallet();
//        for (Position openedPosition : openPositions) {
//            ExchangeService exchangeService = exchangeFactory(openedPosition.getWallet().getExchange().getExchangeName());
//            openedPosition=exchangeService.getPositionInfoFromExchangeServiceApi(openedPosition);
//            Stock stock = stockService.getFullStockInfoFromExternalServiceApi(openedPosition.getStrategy().getStock());
//            openedPosition.getStrategy().setStock(stock);
//            Position afterAnalyzePosition = positionService.analyze(openedPosition);
//            Position afterAnalyzeStock = strategyService.analyzeNew(stock);
//            if (Objects.requireNonNull(afterAnalyzeStock.getTradeAction()) == TradeAction.BUY) {
//                openedPosition = exchangeService.buy(openedPosition);
//            }
//        }


    }


    private ExchangeService exchangeFactory(ExchangeName exchangeNameName) {
        switch (exchangeNameName){
            case BING_X:
                return exchangeBingXService;
                case BINANCE:
                    return exchangeBinanceService;
                    default:
                        return null;
        }
    }




}
