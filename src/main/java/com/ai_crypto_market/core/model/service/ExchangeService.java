package com.ai_crypto_market.core.model.service;

public interface ExchangeService {
    String executeBuy(Long amount);
    String executeSell(Long amount);
    String executeClosePosition(Long amount);
    String executeGetBalance(Long amount);
}
