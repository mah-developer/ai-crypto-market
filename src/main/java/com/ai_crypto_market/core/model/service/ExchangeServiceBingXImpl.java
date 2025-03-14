package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("ExchangeBingXService")
public class ExchangeServiceBingXImpl implements ExchangeService {

    @Override
    public String ExchangeInformation() {

        String result = "";
        return result;
    }


    @Override
    public String OpenPosition(Strategy strategy) {
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

    @Override
    public String openPosition(Wallet wallet, Strategy strategy) {
        return "";
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
    public Position buy(Position openedPosition) {
        return null;
    }

    @Override
    public Position sell(Position openedPosition) {
        return null;
    }

    @Override
    public Stock getFullStockInfoFromExchangeServiceApi(Stock stock) {
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
    public Long getPriceFromExchangeServiceApi(Position openedPosition) {
        System.out.println("get current price from exchange api ...");
        return 10l;
    }

    @Override
    public Long getProfitFromExchangeServiceApi(Position openPosition) {
        System.out.println("get profit from exchange api ...");
        return 2l;
    }


}
