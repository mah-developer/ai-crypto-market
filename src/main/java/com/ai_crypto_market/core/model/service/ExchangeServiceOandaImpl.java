package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.*;
import com.ai_crypto_market.core.model.enums.TimeFrame;
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
    public String GetBalance(Long amount) {
        String response = "long executed in binance with this amount: " + amount;
        System.out.println(response);
        return response;
    }

    @Override
    public String GetProfit(Long amount) {
        String response = "long executed in binance with this amount: " + amount;
        System.out.println(response);
        return response;
    }

    @Override
    public List<ExchangeStock> getAllExchangeStocks() {
        return List.of();
    }

    @Override
    public MarketData fetchMarketData(ExchangeStock exchangeStock) {
        return null;
    }

    @Override
    public Position openPosition(Position position) {
        return null;
    }

    @Override
    public Position closePosition(Position position) {
        return null;
    }

    @Override
    public Position closeAll(Position position) {
        return null;
    }

    @Override
    public Stock getFullStockInfoFromExchangeServiceApi(Stock stock, TimeFrame timeFrame) {
        // previously filled these items: id, name, symbol
        stock.setRsi("39,32,43,65,80"); // last 5 items based on timeFrame
        stock.setMa7("20");
        stock.setMa14("35");
        stock.setMa21("45");
        stock.setVolume("65,54,42,87,69"); // last 5 items based on timeFrame
        stock.setCandle("12,22,23,24;31,32,33,34;41,42,43,44;51,52,53,54"); // last 5 items based on timeFrame
        stock.setPriceAction(50);
        stock.setAiNews(20);
        stock.setSmartMoney(21);
        return stock;
    }
    @Override
    public float getPriceFromExchangeServiceApi(Position openedPosition) {
        System.out.println("get current price from exchange api ...");
        return 26000;
    }

    @Override
    public float getProfitFromExchangeServiceApi(Position openPosition) {
        System.out.println("get profit from exchange api ...");
        return 10;
    }

}
