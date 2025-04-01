package com.ai_crypto_market.core.model.repository;


import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
//    <T> ScopedValue<T> findBySymbol(String s);
    List<Stock> findAllByStrategyIdOrderByCreatedAtDesc(Long strategyId);

}
