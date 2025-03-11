package com.ai_crypto_market.core.model.repository;


import com.ai_crypto_market.core.model.entity.ExchangeStockHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeStockHistoryRepository extends JpaRepository<ExchangeStockHistory, Long> {
}
