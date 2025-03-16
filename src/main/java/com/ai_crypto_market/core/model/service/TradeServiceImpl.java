package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.enums.Exchanges;
import com.ai_crypto_market.core.model.enums.TradeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    PositionServiceImpl positionService;

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
            Long profit = exchangeService.getProfitFromExchangeServiceApi(openedPosition);
            Long currentPrice = exchangeService.getPriceFromExchangeServiceApi(openedPosition);
            Stock stock = exchangeService.getFullStockInfoFromExchangeServiceApi(openedPosition.getStrategy().getStock());
            // in other words we update the previous opened position
            openedPosition.getStrategy().setStock(stock);
            openedPosition.setProfit(profit);
            openedPosition.setCurrentPrice(currentPrice);
            // based on strategy name on openedPosition object we choose the related strategyService
            Position afterAnalyzePosition = positionService.analyze(openedPosition);

            // here we have a full object and new version of strategy object, which contains buy and sell percents
            // todo save strategy, position object for ai purposes
            switch (afterAnalyzePosition.getStrategy().getTradeAction()){
                case TradeAction.BUY -> openedPosition = exchangeService.buy(openedPosition);
                case TradeAction.CLOSEALL -> openedPosition = exchangeService.sell(openedPosition);
            }
            // end each open position
        }
    }


    private ExchangeService exchangeFactory(Exchanges exchangesName) {
        switch (exchangesName){
            case BING_X:
                return exchangeBingXService;
                case BINANCE:
                    return exchangeBinanceService;
                    default:
                        return null;
        }
    }


    private List<Position> getOpenPositions() {
        System.out.println("find and return openPositions ... ");
        List<Position> openPositions = new ArrayList<>();
        return openPositions;
    }


}
