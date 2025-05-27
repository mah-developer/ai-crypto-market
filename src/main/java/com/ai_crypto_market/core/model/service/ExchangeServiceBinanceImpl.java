package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.*;
import com.ai_crypto_market.core.model.enums.ExchangeName;
import com.ai_crypto_market.core.model.enums.TimeFrame;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;


@Service
@Qualifier("ExchangeBinanceService")
public class ExchangeServiceBinanceImpl extends ExchangeServiceCommonImpl {
    //@Autowired
    //private ApiServiceTaapiImpl taapi;


    @Override
    public ExchangeName getExchangeName() {
        return ExchangeName.BINANCE;
    }

    @Override
    public String exchangeInformation() {
        UMFuturesClientImpl client = new UMFuturesClientImpl();
        String result = client.market().exchangeInfo();
        return result;
    }

    public String getMarketPrice(String symbol) {
        UMFuturesClientImpl client = new UMFuturesClientImpl();
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", symbol);
        String result = client.market().markPrice(parameters);
        return result;
    }


    @Override
    public String openPosition(Position position) {
        String apiKey = position.getWallet().getApiKey();
        String secretKey = position.getWallet().getApiSecret();

        UMFuturesClientImpl client = new UMFuturesClientImpl(apiKey, secretKey);

        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", position.getStock().getSymbol());
        parameters.put("side", position.getPositionType());
        parameters.put("type", "MARKET");
        parameters.put("timeInForce", "GTC");
        parameters.put("quantity", position.getQuantity());
        parameters.put("price", position.getStock().getCurrentPrice());

        String result = client.account().newOrder(parameters);
        return result;
    }

    @Override
    public String closePosition(Position position) {
        String response = "sell executed in binance with this amount: " + position.getQuantity().toString();
        System.out.println(response);
        return response;
    }


    @Override
    public Stock getCandleAndVolume(Stock stock) {
        // GET /fapi/v1/klines
        //  Name	    Type	Mandatory	Description
        //  symbol	    STRING	YES
        //  interval	ENUM	YES
        //  startTime	LONG	NO
        //  endTime	    LONG	NO
        //  limit	    INT	    NO	Default 500; max 1500.
        // [
        //  [
        //    1499040000000,      // Open time
        //    "0.01634790",       // Open
        //    "0.80000000",       // High
        //    "0.01575800",       // Low
        //    "0.01577100",       // Close
        //    "148976.11427815",  // Volume
        //    1499644799999,      // Close time
        //    "2434.19055334",    // Quote asset volume
        //    308,                // Number of trades
        //    "1756.87402397",    // Taker buy base asset volume
        //    "28.46694368",      // Taker buy quote asset volume
        //    "17928899.62484339" // Ignore.
        //  ]
        //]
        stock.setVolume("65,54,42,87,69"); // last 5 items based on timeFrame
        stock.setCandle("12,22,23,24;31,32,33,34;41,42,43,44;51,52,53,54"); // last 5 items based on timeFrame
        return stock;
    }

    @Override
    public Stock getStockInfoFromExchangeServiceApi(Stock stock, TimeFrame timeFrame) {
        System.out.println("get current price from exchange api ...");



        stock.setVolume("65,54,42,87,69"); // last 5 items based on timeFrame
        stock.setCandle("12,22,23,24;31,32,33,34;41,42,43,44;51,52,53,54"); // last 5 items based on timeFrame
        stock.setCurrentPrice(new BigDecimal(20));//"markPrice"

        return stock;
    }

    @Override
    public Wallet getAvalableBalance(Wallet wallet) {
        String response = "long executed in binance with this amount: " ;
        System.out.println(response);

        wallet.setAvailableBalance(wallet.getAvailableBalance());
        return wallet;
    }


    @Override
    public Position getPositionInfoFromExchangeServiceApi(Position openedPosition) {
        System.out.println("get current price from exchange api ...");

        //Object info=taapi.getPositionInfoFromExchangeServiceApi(openedPosition);
//        JSONObject
        // GET MarketPrice and position info(profit):  /fapi/v3/positionRisk
        //   Request Parameters
        //   Name	    Type	Mandatory
        //   symbol	    STRING	NO
        //   recvWindow	LONG	NO
        //   timestamp	LONG	YES
        // [
        //  {
        //        "symbol": "ADAUSDT",
        //        "positionSide": "BOTH",               // position side
        //        "positionAmt": "30",
        //        "entryPrice": "0.385",
        //        "breakEvenPrice": "0.385077",
        //        "markPrice": "0.41047590",
        //        "unRealizedProfit": "0.76427700",     // unrealized profit
        //        "liquidationPrice": "0",
        //        "isolatedMargin": "0",
        //        "notional": "12.31427700",
        //        "marginAsset": "USDT",
        //        "isolatedWallet": "0",
        //        "initialMargin": "0.61571385",        // initial margin required with current mark price
        //        "maintMargin": "0.08004280",          // maintenance margin required
        //        "positionInitialMargin": "0.61571385",// initial margin required for positions with current mark price
        //        "openOrderInitialMargin": "0",        // initial margin required for open orders with current mark price
        //        "adl": 2,
        //        "bidNotional": "0",                   // bids notional, ignore
        //        "askNotional": "0",                   // ask notional, ignore
        //        "updateTime": 1720736417660
        //  }
        //]
        openedPosition.setProfit(new BigDecimal(2));//"unRealizedProfit"
        openedPosition.getStock().setCurrentPrice(new BigDecimal(20));//"markPrice"
        openedPosition.getWallet().setAvailableBalance(BigDecimal.valueOf(100));//"isolatedWallet"
        return openedPosition;
    }

    @Override
    public int checkWeightStock(Stock stock) {
        return 0;
    }


}
