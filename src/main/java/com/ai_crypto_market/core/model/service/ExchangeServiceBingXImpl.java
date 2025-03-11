package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.ExchangeStock;
import com.ai_crypto_market.core.model.entity.MarketData;
import com.ai_crypto_market.core.model.entity.Signal;
import com.ai_crypto_market.core.model.entity.Wallet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
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
    public String OpenPosition(Signal signal) {
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
    public String openPosition(Wallet wallet, Signal signal) {
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


}
