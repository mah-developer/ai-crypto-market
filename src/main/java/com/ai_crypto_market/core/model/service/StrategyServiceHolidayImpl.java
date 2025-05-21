package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.Wallet;
import com.ai_crypto_market.core.model.enums.StrategyType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("signalServiceHoliday")
public class StrategyServiceHolidayImpl implements StrategyService {

    @Override
    public StrategyType getStrategyType() {
        return StrategyType.HOLIDAY;
    }

    @Override
    public Position analyzeUpdate(Position position, Position newPosition, List<Position> positionHistoryBasedOnExchangeId) {
        return newPosition;
    }

    @Override
    public Position analyzeNew(Stock stock) {
        Position position = new Position();
        return position;
    }

    @Override
    public void onInitialApplicationPersistDefaultStrategy() {

    }

}
