package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Strategy;
import com.ai_crypto_market.core.model.entity.Stock;

public interface StrategyService {
    Strategy analyze(Position position);
}
