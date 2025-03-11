package com.ai_crypto_market.core.model.repository;


import com.ai_crypto_market.core.model.entity.Signal;
import com.ai_crypto_market.core.model.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignalRepository extends JpaRepository<Signal, Long> {
}
