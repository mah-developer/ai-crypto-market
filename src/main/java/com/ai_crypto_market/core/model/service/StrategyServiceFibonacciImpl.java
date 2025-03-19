package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Strategy;
import com.ai_crypto_market.core.model.enums.TradeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Qualifier("signalServiceFibonacci")
public class StrategyServiceFibonacciImpl implements StrategyService {
    @Autowired
    PositionServiceImpl positionService;

    @Override
    public Position analyzeUpdate(Position position) {
        Position newPosition = positionService.fillPositionObject(position);
        // we have new position here
        // todo get fresh value of currentPrice, availableBalance and profit from exchange here

        // check Strategy For Update Position ////////
        var TPu=position.getCurrentStopLoss();
        var SLu=position.getCurrentStopLoss();
        var price=position.getCurrentStopLoss();
        var profit=position.getProfit();
        /// ///////////////////////////////////////////

        // START STRATEGY -----------------------------------------------
        // check price, profit, and stoploss to set ( tradeaction , and if needed ( set stoploss,target or quantity ) )
        if(newPosition.getProfit()>12)
        {
            newPosition.getStrategy().setTradeAction(TradeAction.CHANGETPSL);
            newPosition.setCurrentStopLoss(0L);
            newPosition.setCurrentTargetPrice(0L);
        }
        else if(newPosition.getProfit()<21)
        {
            newPosition.setQuantity(10L);
            newPosition.getStrategy().setTradeAction(TradeAction.BUY);
        }
        else if(newPosition.getProfit()==21)
        {
            newPosition.setQuantity(20L);
            newPosition.getStrategy().setTradeAction(TradeAction.CLOSE);
        }
        else if(newPosition.getProfit()>=55)
        {
            newPosition.getStrategy().setTradeAction(TradeAction.CLOSEALL);
        }
        else
            newPosition.getStrategy().setTradeAction(TradeAction.NONE);

        return newPosition;
    }

    @Override
    public Position analyzeNew()
    {
//        Position newPosition = positionService.fillPositionObject(position);
//        // THIS BLOCK CODE FOR NEW POSITION in STRATEGY ////////////////////////
//        var timeframe= Strategy // 1H
//        var TP=position.getStrategy().getDefaultTargetPercent(); // 5%
//        var SL=position.getStrategy().getDefaultStoplossPercent(); // 3%
//        if (position.getStrategy().getBuyPercent().compareTo(position.getWallet().getMaxPercentOfAvailablePerPosition()) > 0) {
//            position.getStrategy().setBuyPercent(position.getWallet().getMaxPercentOfAvailablePerPosition());
//        }
//        var perbalance=position.getStrategy().getBuyPercent(); // 8%
//        if (position.getStrategy().getDefaultLeverage().compareTo(position.getWallet().getMaxLeverage()) > 0) {
//            position.getStrategy().setDefaultLeverage(position.getWallet().getMaxLeverage());
//        }
//        var leverage=position.getStrategy().getDefaultLeverage(); // 2%
//        /// //////////////////////////////////////////////////////////////////


        return null;
    }
}
