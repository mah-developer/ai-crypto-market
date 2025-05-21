package com.ai_crypto_market.core.controller;

import com.ai_crypto_market.core.model.entity.taapi.*;
import com.ai_crypto_market.core.model.service.ApiService;
import com.ai_crypto_market.core.model.service.StrategyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
     * 	http://localhost:8585/api/test/get-rsi-taapi?exchange=binance&symbol=BTC/USDT&interval=1h&results=3
     * */
// https://api.taapi.io/rsi?secret=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbHVlIjoiNjA5MmNmY2M0MjI0NmNlM2IwZWNiYjI1IiwiaWF0IjoxNzQ2MjAwOTc0LCJleHAiOjMzMjUwNjY0OTc0fQ.yDldr9qdcTho7bwLDT8fuBH0xnEBtr7bKtE5tdzUzRE&exchange=binance&symbol=BTC/USDT&interval=1h&results=10
//    {"value":[58.10957301301897,50.920935535066725,55.562941072621065,54.79228469268418,59.276241814290174,59.8789423955054,63.48116190586461,54.88994306054188,66.50271967472405,60.09669666659495]}

    @GetMapping("/get-rsi-taapi")
    public String getRsiTaapi(
            @RequestParam String exchange,
            @RequestParam String symbol,
            @RequestParam String interval,
            @RequestParam int results
    ) throws JsonProcessingException {
        RsiResponse rsi= apiServiceTaapi.getRsiIndicator(exchange, symbol, interval,results);

        return Arrays.toString(rsi.getValue());
    }

    /**
     * 	http://localhost:8585/api/test/get-volume-taapi?exchange=binance&symbol=BTC/USDT&interval=1h&results=1
     * */
    @GetMapping("/get-volume-taapi")
    public VolumeResponse getVolumeTaapi(
            @RequestParam String exchange,
            @RequestParam String symbol,
            @RequestParam String interval,
            @RequestParam int results
    ) {
        return apiServiceTaapi.getVolumeIndicator(exchange, symbol, interval, results);
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

