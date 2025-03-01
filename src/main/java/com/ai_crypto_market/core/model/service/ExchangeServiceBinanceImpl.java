package com.ai_crypto_market.core.model.service;

import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;


@Service
@Qualifier("ExchangebinanceService")
public class ExchangeServiceBinanceImpl implements ExchangeService {
    String API_KEY="";
    String API_SECRET="";


    @Override
    public String ExchangeInformation() {
        UMFuturesClientImpl client = new UMFuturesClientImpl();
        String result = client.market().exchangeInfo();
        return result;
    }


    @Override
    public String OpenPosition(Long amount) {
        LinkedHashMap<String,Object> parameters = new LinkedHashMap<String,Object>();
        UMFuturesClientImpl client = new UMFuturesClientImpl(API_KEY, API_SECRET);

        parameters.put("symbol","BTCUSDT");
        parameters.put("side", "SELL");
        parameters.put("type", "LIMIT");
        parameters.put("timeInForce", "GTC");
        parameters.put("quantity", 0.01);
        parameters.put("price", 9500);

        String result = client.account().newOrder(parameters);
        return result;
    }

    @Override
    public String ClosePosition(Long amount) {
        String response = "sell executed in binance with this amount: " + amount;
        System.out.println(response);
        return response;
    }

    @Override
    public String GetBalance(Long amount) {
        String response = "long executed in binance with this amount: " + amount;
        System.out.println(response);
        return response;
    }
    
    
}
