package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.ExchangeStock;
import com.ai_crypto_market.core.model.entity.MarketData;
import com.ai_crypto_market.core.model.entity.Signal;
import com.ai_crypto_market.core.model.entity.Wallet;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service
@Qualifier("ExchangeBinanceService")
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
    public String OpenPosition(Signal signal) {
        signal.getStock().getExchangeStocks().stream().forEach(exchangeStock -> {
            exchangeStock.getExchange().getWallets().stream().forEach(wallet -> {
                // todo call binance api
                // wallet
                UMFuturesClientImpl client = new UMFuturesClientImpl(wallet.getApiKey(),wallet.getApiSecret());
                LinkedHashMap<String,Object> parameters = new LinkedHashMap<String,Object>();
                parameters.put("symbol",signal.getStock().getSymbol());
                parameters.put("side", signal.getPositionType());
                parameters.put("type", signal.getOrderType());
                parameters.put("timeInForce", "GTC");
                parameters.put("quantity", signal.getQuantity());
                parameters.put("price", signal.getEntryPrice());

                String result = client.account().newOrder(parameters);
            });
        });

//        for (ExchangeStock exchangeStock : signal.getStock().getExchangeStocks()) {
//            for (Wallet wallet : exchangeStock.getExchange().getWallets()) {
//                // todo call binance api
//            }
//        }

        return "";
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
