package com.ai_crypto_market.core.model.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
@Qualifier("ExchangebingxService")
public class ExchangeServiceBingXImpl implements ExchangeService {

    @Override
    public String ExchangeInformation() {

        String result = "";
        return result;
    }


    @Override
    public String OpenPosition(Long amount) {
        return "";
    }

    @Override
    public String ClosePosition(Long amount) {
        String response = "sell executed in CoinMarketCap with this amount: " + amount;
        System.out.println(response);
        return response;
    }


    @Override
    public String GetBalance(Long amount) {
        String response = "long executed in CoinMarketCap with this amount: " + amount;
        System.out.println(response);
        return response;
    }
    
    
}
