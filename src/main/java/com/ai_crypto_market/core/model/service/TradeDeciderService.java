package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Indicator;
import com.ai_crypto_market.core.model.entity.IndicatorIchimoku;
import com.ai_crypto_market.core.model.entity.IndicatorRSI;
import com.ai_crypto_market.core.model.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TradeDeciderService {

    @Autowired
    @Qualifier("IndicatorrsiService")
    private IndicatorService RSIIndicatorService;

    @Autowired
    @Qualifier("IndicatorichimokuService")
    private IndicatorService ichimokuIndicatorService;

    @Autowired
    @Qualifier("ExchangebingxService")
    private ExchangeService bingXExchangeService;

    @Autowired
    @Qualifier("ExchangebinanceService")
    private ExchangeService binanceExchangeService;

    public String doTrade(Stock stock) {
        Long amount = getTotalAssetsFromStock(stock);
        String result = "";
        System.out.println("trade calculation started");

        ExchangeService exchangeService = exchangeFactory(stock.getExchange().getName());

        // Null check
        if (ichimokuIndicatorService == null || RSIIndicatorService == null) {
            throw new IllegalStateException("Indicator services are not injected properly!");
        }

        //IndicatorIchimoku ichimokuCurrentSignal = ichimokuIndicatorService.getCurrentSignal(stock);
        //IndicatorRSI rsiCurrentSignal = RSIIndicatorService.getCurrentSignal(stock);

        // todo go to different method
        int totalBuyPercent = 0;//((ichimokuCurrentSignal.getBuyPercent() * ichimokuCurrentSignal.getAccuracy()) + (rsiCurrentSignal.getBuyPercent() * rsiCurrentSignal.getAccuracy())) / 2;
        int totalSellPercent = 0;//((ichimokuCurrentSignal.getSellPercent() * ichimokuCurrentSignal.getAccuracy()) + (rsiCurrentSignal.getSellPercent() * rsiCurrentSignal.getAccuracy())) / 2;

        // todo go to different method
        if (totalBuyPercent > totalSellPercent) {
            System.out.println("decide to buy " + amount + " of " + stock.getName());
            exchangeService.executeBuy(amount);
            result = amount + " of " + stock.getName() + "bought";
        } else {
            System.out.println("decide to sell " + amount + " of " + stock.getName());
            exchangeService.executeSell(amount);
            result = amount + " of " + stock.getName() + " sold";
        }

        System.out.println("trade calculation finished.");
        return result;
    }

    private Long getTotalAssetsFromStock(Stock stock) {
        //todo Find the total amount of assets from this stock.
        return 15L;
    }

    public ExchangeService exchangeFactory(String exchangeName) {
        switch (exchangeName) {
            case "binance":
                return binanceExchangeService;
            case "coinMar":
                return bingXExchangeService;
            default:
                return binanceExchangeService;
        }
    }
}
