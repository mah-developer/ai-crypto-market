package com.ai_crypto_market.core.model.repository;


import com.ai_crypto_market.core.model.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query("select o from Stock o join fetch o.strategies i where i.id =:strategyId order by o.createdAt desc ")
    Set<Stock> findAllByStrategyIdOrderByCreatedAtDesc(@Param("strategyId") Long strategyId);

}
