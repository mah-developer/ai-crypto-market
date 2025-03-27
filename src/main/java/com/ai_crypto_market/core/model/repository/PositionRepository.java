package com.ai_crypto_market.core.model.repository;

import com.ai_crypto_market.core.model.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    List<Position> findByExchangePositionId(String exchangePositionId);
    List<Position> findAllByExchangePositionIdOrderByCreatedAtDesc(String exchangePositionId);
}
