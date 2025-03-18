package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
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
    public Position analyze(Position position) {
        Position newPosition = positionService.fillPositionObject(position);
        // we have new position here
        // todo get fresh value of currentPrice, availableBalance and profit from exchange here


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

}
