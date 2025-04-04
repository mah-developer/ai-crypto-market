package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.enums.StrategyType;

import java.util.List;

public interface StrategyService {
    StrategyType getStrategyType();
    Position analyzeUpdate(Position position, Position newPosition, List<Position> positionHistoryBasedOnExchangeId);
    Position analyzeNew(Stock stock);
    // todo: call it on application startup
    void onInitialApplicationPersistDefaultStrategy();
}
