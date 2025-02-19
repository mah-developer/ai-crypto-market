package com.ai_crypto_market.core.model.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("coinMarketCapExchangeService")
public class CoinMarketCapExchangeServiceImpl implements ExchangeService {
    @Override
    public String executeBuy(Long amount) {
        String response = "buy executed in CoinMarketCap with this amount: " + amount;
        System.out.println(response);
        return response;
    }

    @Override
    public String executeSell(Long amount) {
        String response = "sell executed in CoinMarketCap with this amount: " + amount;
        System.out.println(response);
        return response;
    }

    @Override
    public String executeShort(Long amount) {
        String response = "short executed in CoinMarketCap with this amount: " + amount;
        System.out.println(response);
        return response;
    }

    @Override
    public String executeLong(Long amount) {
        String response = "long executed in CoinMarketCap with this amount: " + amount;
        System.out.println(response);
        return response;
    }
    
    
}
