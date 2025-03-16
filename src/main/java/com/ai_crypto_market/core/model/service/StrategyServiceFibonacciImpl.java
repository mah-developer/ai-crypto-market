package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.enums.TradeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
        newPosition.setCurrentStopLoss(0l);
        newPosition.setCurrentTargetPrice(0l);

        newPosition.getWallet();
        // after calculations (for example from wallet setting) calculate quantity
        newPosition.setQuantity(10l);

        // if strategy equals TradeAction.NONE => then update wallet.availableBalance
        newPosition.getStrategy().setTradeAction(TradeAction.BUY);

        return newPosition;
    }

}
