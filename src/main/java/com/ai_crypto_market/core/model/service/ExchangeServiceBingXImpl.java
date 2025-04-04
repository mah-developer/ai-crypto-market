package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.*;
import com.ai_crypto_market.core.model.enums.ExchangeName;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("ExchangeBingXService")
public class ExchangeServiceBingXImpl extends ExchangeServiceCommonImpl {

    @Override
    public ExchangeName getExchangeName() {
        return ExchangeName.BING_X;
    }

    @Override
    public String exchangeInformation() {

        String result = "";
        return result;
    }


    @Override
    public String openPosition(Strategy strategy) {
        return "";
    }

    @Override
    public String closePosition(Long amount) {
        String response = "sell executed in CoinMarketCap with this amount: " + amount;
        System.out.println(response);
        return response;
    }


    @Override
    public String getBalance(Long amount) {
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
