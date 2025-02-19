package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.common.annotation.Binance;

@Binance
public class BinanceExchangeServiceImpl implements ExchangeService {
    @Override
    public String executeBuy(Long amount) {
        String response = "buy executed in binance with this amount: " + amount;
        System.out.println(response);
        return response;
    }

    @Override
    public String executeSell(Long amount) {
        String response = "sell executed in binance with this amount: " + amount;
        System.out.println(response);
        return response;
    }

    @Override
    public String executeShort(Long amount) {
        String response = "short executed in binance with this amount: " + amount;
        System.out.println(response);
        return response;
    }

    @Override
    public String executeLong(Long amount) {
        String response = "long executed in binance with this amount: " + amount;
        System.out.println(response);
        return response;
    }
    
    
}
