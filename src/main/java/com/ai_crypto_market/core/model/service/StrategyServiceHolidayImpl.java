package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Strategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("signalServiceHoliday")
public class StrategyServiceHolidayImpl implements StrategyService {
    @Override
    public Strategy analyze(Position position) {
        return null;
    }
}
