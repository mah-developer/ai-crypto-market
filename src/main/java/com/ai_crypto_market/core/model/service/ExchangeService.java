package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.ExchangeStock;
import com.ai_crypto_market.core.model.entity.MarketData;
import com.ai_crypto_market.core.model.entity.Signal;
import com.ai_crypto_market.core.model.entity.Wallet;

import java.util.List;

public interface ExchangeService {
    String ExchangeInformation();
    String OpenPosition(Signal signal);
    String ClosePosition(Long amount);
    String GetBalance(Long amount);

    String openPosition(Wallet wallet, Signal signal);

    List<ExchangeStock> getAllExchangeStocks();

    MarketData fetchMarketData(ExchangeStock exchangeStock);
}
