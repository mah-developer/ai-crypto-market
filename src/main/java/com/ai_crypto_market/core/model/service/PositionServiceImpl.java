package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.enums.StrategyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    @Qualifier("signalServiceFibonacci")
    private StrategyService strategyServiceFibonacci;

    @Autowired
    @Qualifier("signalServiceHoliday")
    private StrategyService strategyServiceHoliday;

    @Override
    public Position analyze(Position openedPosition) {
        StrategyService strategyService = strategyFactory(openedPosition.getStrategy().getType());
        return strategyService.analyze(openedPosition);
    }

    private StrategyService strategyFactory(StrategyType strategyType) {
        switch (strategyType) {
            case FIBONACCI:
                return strategyServiceFibonacci;
            case HOLIDAY:
                return strategyServiceHoliday;
            default:
                return null;
        }
    }

    public Position fillPositionObject(Position position) {
        Position newPosition = new Position();
        newPosition.setExchangePositionId(position.getExchangePositionId());
        newPosition.setStrategy(position.getStrategy());
        newPosition.setWallet(position.getWallet());
        newPosition.setCurrentTargetPrice(position.getCurrentTargetPrice());
        newPosition.setCurrentStopLoss(position.getCurrentStopLoss());
        newPosition.setEntryPrice(position.getEntryPrice());
        newPosition.setQuantity(position.getQuantity());
        newPosition.setPositionStatus(position.getPositionStatus());
        newPosition.setPositionType(position.getPositionType());
        newPosition.setProfit(position.getProfit());
        newPosition.setExchangePositionId(position.getExchangePositionId());
        newPosition.setCurrentPrice(position.getCurrentPrice());
        return newPosition;
    }


}
