package com.ai_crypto_market.core.model.repository;


import com.ai_crypto_market.core.model.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    List<Wallet> findAllByStrategyIdOrderByCreatedAtDesc(Long strategyId);
    List<Wallet> getWalletByExchangeIdOrderByCreatedAtDesc(Long ExchangeId);
    @Query("select w from Wallet w where w.isActive ORDER BY w.createdAt DESC")
    List<Wallet> getAllActiveWalletOrderByCreatedAtDesc();
}
