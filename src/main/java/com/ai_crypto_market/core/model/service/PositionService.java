package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;

import java.util.List;

public interface PositionService {
    Position analyze(Position openedPosition);

    Position changeTargetPriceAndStopLoss(Position openedPosition);

    List<Position> findAllByExchangePositionIdOrderByCreatedAtDesc(String exchangePositionId);

    List<Position> getOpenPositions();
}
