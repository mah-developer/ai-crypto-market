package com.ai_crypto_market.core.model.service;

public interface ExchangeService {
    String ExchangeInformation();
    String OpenPosition(Long amount);
    String ClosePosition(Long amount);
    String GetBalance(Long amount);
}
