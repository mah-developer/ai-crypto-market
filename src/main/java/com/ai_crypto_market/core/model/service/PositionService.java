package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;

public interface PositionService {
    Position analyze(Position openedPosition);
}
