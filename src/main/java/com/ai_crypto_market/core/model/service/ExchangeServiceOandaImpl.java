package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.*;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;


// forex exchange (e.g., OANDA)
@Service
@Qualifier("ExchangeOandaService")
public class ExchangeServiceOandaImpl implements ExchangeService {
    String API_KEY="";
    String API_SECRET="";


    @Override
    public String ExchangeInformation() {
        UMFuturesClientImpl client = new UMFuturesClientImpl();
        String result = client.market().exchangeInfo();
        return result;
    }


    @Override
    public String OpenPosition(Strategy strategy) {
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

    @Override
    public String openPosition(Wallet wallet, Strategy strategy) {
        return "";
    }

    @Override
    public List<ExchangeStock> getAllExchangeStocks() {
        return List.of();
    }

    @Override
    public Position buy(Position openedPosition) {
        return null;
    }

    @Override
    public Position sell(Position openedPosition) {
        return null;
    }

    @Override
    public Stock getCandlestickDataFromExchangeServiceApi(Stock stock) {
        return stock;
    }

    @Override
    public Position getPositionInfoFromExchangeServiceApi(Position openedPosition) {
        return openedPosition;
    }

}
