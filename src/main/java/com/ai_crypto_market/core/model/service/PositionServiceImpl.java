package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.enums.StrategyType;
import com.ai_crypto_market.core.model.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    @Qualifier("signalServiceFibonacci")
    private StrategyService strategyServiceFibonacci;

    @Autowired
    @Qualifier("signalServiceHoliday")
    private StrategyService strategyServiceHoliday;

    @Autowired
    PositionRepository positionRepository;

    @Override
    public Position analyze(Position openedPosition) {
        StrategyService strategyService = strategyFactory(openedPosition.getStrategy().getType());
        List<Position> positionHistoryBasedOnExchangeId = findAllByExchangePositionIdOrderByCreatedAtDesc(openedPosition.getExchangePositionId());
        Position newPosition = fillPositionObject(openedPosition);
        return strategyService.analyzeUpdate(openedPosition, newPosition, positionHistoryBasedOnExchangeId);
    }


    @Override
    public Position changeTargetPriceAndStopLoss(Position openedPosition) {
        return null;
    }

    @Override
    public List<Position> findAllByExchangePositionIdOrderByCreatedAtDesc(String exchangePositionId) {
        return positionRepository.findAllByExchangePositionIdOrderByCreatedAtDesc(exchangePositionId);
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

    @Override
    public List<Position> getOpenPositions() {
        System.out.println("find and return openPositions ... ");
        List<Position> openPositions = new ArrayList<>();
        return openPositions;
    }

}
