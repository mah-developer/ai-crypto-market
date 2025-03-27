package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("signalServiceHoliday")
public class StrategyServiceHolidayImpl implements StrategyService {

    @Override
    public Position analyzeUpdate(Position position, Position newPosition, List<Position> positionHistoryBasedOnExchangeId) {
        return null;
    }

    @Override
    public Position analyzeNew() {
        return null;
    }

}
