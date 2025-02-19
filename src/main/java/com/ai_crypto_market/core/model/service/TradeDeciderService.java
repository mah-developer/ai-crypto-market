package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.common.annotation.Binance;
import com.ai_crypto_market.core.common.annotation.CoinMarketCap;
import com.ai_crypto_market.core.common.annotation.Ichimoku;
import com.ai_crypto_market.core.common.annotation.RSI;

public class TradeDeciderService {

    @RSI
    private IndicatorService RSIIndicatorService;

    @Ichimoku
    private IndicatorService ichimokuIndicatorService;

    @CoinMarketCap
    private ExchangeService coinMarketCapExchangeService;

    @Binance
    private ExchangeService binanceExchangeService;

    public String doTrade() {
        String result = "trade executed ...";


        System.out.println(result);
        return result;
    }

    public ExchangeService exchangeFactory(String exchangeName) {
        switch (exchangeName) {
            case "binance":
                return binanceExchangeService;
            case "coinMar":
                return coinMarketCapExchangeService;
            default:
                return binanceExchangeService;
        }
    }

    public IndicatorService indicatorFactory(String indicatorName) {
        switch (indicatorName) {
            case "ichimoku":
                return ichimokuIndicatorService;
            case "rsi":
                return RSIIndicatorService;
            default:
                return RSIIndicatorService;
        }
    }


}
