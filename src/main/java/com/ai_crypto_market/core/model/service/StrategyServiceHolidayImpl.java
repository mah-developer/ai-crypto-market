package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("signalServiceHoliday")
public class StrategyServiceHolidayImpl implements StrategyService {
    @Autowired
    PositionServiceImpl positionService;

    @Override
    public Position analyze(Position position) {
        Position newPosition = positionService.fillPositionObject(position);

        return newPosition;
    }

}
