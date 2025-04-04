package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Wallet;

import java.util.List;

public interface WalletService {
    List<Wallet> findAllByStrategyIdOrderByCreatedAtDesc(Long strategyId);
    List<Wallet> getWalletByExchangeIdOrderByCreatedAtDesc(Long ExchangeId);
    List<Wallet> getAllActiveWalletOrderByCreatedAtDesc();
}
