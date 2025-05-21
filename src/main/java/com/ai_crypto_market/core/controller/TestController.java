package com.ai_crypto_market.core.controller;

import com.ai_crypto_market.core.model.entity.taapi.*;
import com.ai_crypto_market.core.model.service.ApiService;
import com.ai_crypto_market.core.model.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    @Qualifier("strategyServiceFibonacci")
    private StrategyService strategyService;

    @Autowired
    @Qualifier("apiServiceTaapi")
    private ApiService apiServiceTaapi;

    /**
     * 	http://localhost:8585/api/test/get-macd-taapi?exchange=binance&symbol=BTC/USDT&interval=1h
     * */
    @GetMapping("/get-macd-taapi")
    public MacdResponse getMacdTaapi(
            @RequestParam String exchange,
            @RequestParam String symbol,
            @RequestParam String interval
    ) {
        return apiServiceTaapi.getMacdIndicator(exchange, symbol, interval);
    }

    /**
     * 	http://localhost:8585/api/test/get-rsi-taapi?exchange=binance&symbol=BTC/USDT&interval=1h
     * */
    @GetMapping("/get-rsi-taapi")
    public RsiResponse getRsiTaapi(
            @RequestParam String exchange,
            @RequestParam String symbol,
            @RequestParam String interval
    ) {
        return apiServiceTaapi.getRsiIndicator(exchange, symbol, interval);
    }

    /**
     * http://localhost:8585/api/test/get-sma-taapi?exchange=binance&symbol=BTC/USDT&interval=1h&period=14
     * */

    @GetMapping("/get-sma-taapi")
    public SmaResponse getSmaTaapi(
            @RequestParam String exchange,
            @RequestParam String symbol,
            @RequestParam String interval,
            @RequestParam int period
    ) {
        return apiServiceTaapi.getSmaIndicator(exchange, symbol, interval, period);
    }

    /**
     * http://localhost:8585/api/test/get-ema-taapi?exchange=binance&symbol=BTC/USDT&interval=1h&period=14
     * */
    @GetMapping("/get-ema-taapi")
    public EmaResponse getEmaTaapi(
            @RequestParam String exchange,
            @RequestParam String symbol,
            @RequestParam String interval,
            @RequestParam int period
    ) {
        return apiServiceTaapi.getEmaIndicator(exchange, symbol, interval, period);
    }

    /**
     * http://localhost:8585/api/test/get-bulk-taapi?exchange=binance&symbol=BTC/USDT&interval=1h
     * */
    @GetMapping("/get-bulk-taapi")
    public BulkIndicatorResponse getBulkTaapi(
            @RequestParam String exchange,
            @RequestParam String symbol,
            @RequestParam String interval
    ) {
        return apiServiceTaapi.getBulkIndicators(exchange, symbol, interval);
    }

    /**
     * http://localhost:8585/api/test/get-manual-taapi?exchange=binance&symbol=BTC/USDT&interval=1h&indicators=rsi,macd,sma
     * */
    @GetMapping("/get-manual-taapi")
    public ManualAnalysisResponse getManualTaapi(
            @RequestParam String exchange,
            @RequestParam String symbol,
            @RequestParam String interval,
            @RequestParam String indicators // comma-separated e.g. "rsi,macd"
    ) {
        return apiServiceTaapi.getManualAnalysis(exchange, symbol, interval, indicators);
    }

    /**
     * 	http://localhost:8585/api/test/get-historical-taapi?exchange=binance&symbol=BTC/USDT&interval=1h&indicator=macd&backtrack=10
     * */
    @GetMapping("/get-historical-taapi")
    public HistoricalIndicatorResponse getHistoricalTaapi(
            @RequestParam String exchange,
            @RequestParam String symbol,
            @RequestParam String interval,
            @RequestParam String indicator,
            @RequestParam int backtrack
    ) {
        return apiServiceTaapi.getHistoricalAnalysis(exchange, symbol, interval, indicator, backtrack);
    }

}

