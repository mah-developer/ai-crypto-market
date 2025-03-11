//package com.ai_crypto_market.core.model.service;
//
//import com.ai_crypto_market.core.model.entity.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TradeDeciderService {
//
//    @Autowired
//    @Qualifier("IndicatorrsiService")
//    private IndicatorService RSIIndicatorService;
//
//    @Autowired
//    @Qualifier("IndicatorichimokuService")
//    private IndicatorService ichimokuIndicatorService;
//
//    @Autowired
//    @Qualifier("ExchangeBingXService")
//    private ExchangeService bingXExchangeService;
//
//    @Autowired
//    @Qualifier("ExchangeBinanceService")
//    private ExchangeService binanceExchangeService;
//
//    public String doTrade(Stock stock) {
//        Long amount = getTotalAssetsFromStock(stock);
//        String result = "";
//        System.out.println("trade calculation started");
//
//        ExchangeService exchangeService = exchangeFactory(stock.getName());
//
//        // Null check
//        if (ichimokuIndicatorService == null || RSIIndicatorService == null) {
//            throw new IllegalStateException("Indicator services are not injected properly!");
//        }
//
//        //IndicatorIchimoku ichimokuCurrentSignal = ichimokuIndicatorService.getCurrentSignal(stock);
//        //IndicatorRSI rsiCurrentSignal = RSIIndicatorService.getCurrentSignal(stock);
//
//        // todo go to different method
//        int totalBuyPercent = 0;//((ichimokuCurrentSignal.getBuyPercent() * ichimokuCurrentSignal.getAccuracy()) + (rsiCurrentSignal.getBuyPercent() * rsiCurrentSignal.getAccuracy())) / 2;
//        int totalSellPercent = 0;//((ichimokuCurrentSignal.getSellPercent() * ichimokuCurrentSignal.getAccuracy()) + (rsiCurrentSignal.getSellPercent() * rsiCurrentSignal.getAccuracy())) / 2;
//
//        // todo go to different method
//        if (totalBuyPercent > totalSellPercent) {
//            System.out.println("decide to buy " + amount + " of " + stock.getName());
//            exchangeService.OpenPosition(new Signal());
//            result = amount + " of " + stock.getName() + "bought";
//        } else {
//            System.out.println("decide to sell " + amount + " of " + stock.getName());
//            exchangeService.OpenPosition(new Signal());
//            result = amount + " of " + stock.getName() + " sold";
//        }
//
//        System.out.println("trade calculation finished.");
//        return result;
//    }
//
//    private Long getTotalAssetsFromStock(Stock stock) {
//        //todo Find the total amount of assets from this stock.
//        return 15L;
//    }
//
//    public ExchangeService exchangeFactory(String exchangeName) {
//        switch (exchangeName) {
//            case "binance":
//                return binanceExchangeService;
//            case "coinMar":
//                return bingXExchangeService;
//            default:
//                return binanceExchangeService;
//        }
//    }
//}
