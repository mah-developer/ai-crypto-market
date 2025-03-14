package com.ai_crypto_market.core.model.repository;


import com.ai_crypto_market.core.model.entity.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignalRepository extends JpaRepository<Strategy, Long> {
}
