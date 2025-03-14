package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.Strategy;
import com.ai_crypto_market.core.model.enums.Exchanges;
import com.ai_crypto_market.core.model.enums.StrategyType;
import com.ai_crypto_market.core.model.enums.TradeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    @Qualifier("signalServiceFibonacci")
    private StrategyService strategyServiceFibonacci;


    @Autowired
    @Qualifier("signalServiceHoliday")
    private StrategyService strategyServiceHoliday;

    @Autowired
    @Qualifier("ExchangeBingXService")
    private ExchangeService exchangeBingXService;

    @Autowired
    @Qualifier("ExchangeBinanceService")
    private ExchangeService exchangeBinanceService;

    public void doTrade() {
        List<Position> openPositions = getOpenPositions();
        for (Position openedPosition : openPositions) {
            // fill ai news based it's service
            ExchangeService exchangeService = exchangeFactory(openedPosition.getWallet().getExchange().getExchangeName());
            float profit = exchangeService.getProfitFromExchangeServiceApi(openedPosition);
            float currentPrice = exchangeService.getPriceFromExchangeServiceApi(openedPosition);
            Stock stock = exchangeService.getFullStockInfoFromExchangeServiceApi(openedPosition.getStrategy().getStock(),openedPosition.getStrategy().getTimeFrame());
            // in other words we update the previous opened position
            openedPosition.getStrategy().setStock(stock);
            openedPosition.setProfit(profit);
            openedPosition.setCurrentPrice(currentPrice);
            // based on strategy name on openedPosition object we choose the related strategyService
            StrategyService strategyService = strategyFactory(openedPosition.getStrategy().getType());
            Strategy afterAnalyzeStrategy = strategyService.analyze(openedPosition);

            // here we have a full object and new version of strategy object, which contains buy and sell percents
            // todo save strategy, position object for ai purposes
            switch (afterAnalyzeStrategy.getTradeAction()){
                // todo add timeframe in enums and strategy entity
                // todo long to float in position entity
                // todo add timeframe parameter in getFullStockInfoFromExchangeServiceApi
                // todo change TradeAction value enums

                // todo ?? replace getStock to getStrategy in getFullStockInfoFromExchangeServiceApi
                // todo ?? add positionType to Strategy entity
                // todo ?? exchangeService.buy(openedPosition or afterAnalyzeStrategy)
                case TradeAction.BUY -> openedPosition = exchangeService.openPosition(openedPosition);
                case TradeAction.CLOSE -> openedPosition = exchangeService.closePosition(openedPosition);
                case TradeAction.CLOSEALL -> openedPosition = exchangeService.closeAll(openedPosition);
                // todo ?? CHANGETPSL , update database only
                case TradeAction.CHANGETPSL -> openedPosition = exchangeService.closeAll(openedPosition);
            }
            // end each open position
        }

        // todo get all active wallets
        // todo get current strategytype
        // todo for in wallets and for in strategy.stacks and ......
    }

    private StrategyService strategyFactory(StrategyType strategyType) {
        return switch (strategyType) {
            case FIBONACCI -> strategyServiceFibonacci;
            case HOLIDAY -> strategyServiceHoliday;
            default -> null;
        };
    }

    private ExchangeService exchangeFactory(Exchanges exchangesName) {
        return switch (exchangesName) {
            case BING_X -> exchangeBingXService;
            case BINANCE -> exchangeBinanceService;
            default -> null;
        };
    }


    private List<Position> getOpenPositions() {
        System.out.println("find and return openPositions ... ");
        List<Position> openPositions = new ArrayList<>();
        return openPositions;
    }


}
