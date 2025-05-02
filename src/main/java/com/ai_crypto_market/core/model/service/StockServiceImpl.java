package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.taapi.RsiResponse;
import com.ai_crypto_market.core.model.entity.taapi.VolumeResponse;
import com.ai_crypto_market.core.model.enums.ExchangeName;
import com.ai_crypto_market.core.model.enums.TimeFrame;
import com.ai_crypto_market.core.model.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    @Qualifier("apiServiceTaapi")
    private ApiService apiServiceTaapi;

    @Override
    public Stock getFullStockInfoFromExternalServiceApi(Stock stock, ExchangeName exchangeName, TimeFrame timeFrame) {
        RsiResponse rsiIndicator = apiServiceTaapi.getRsiIndicator(exchangeName.name(), stock.getSymbol(), timeFrame.getValue(), 5);
        VolumeResponse volIndicator = apiServiceTaapi.getVolumeIndicator(exchangeName.name(), stock.getSymbol(), timeFrame.getValue(), 5);

        stock.setRsi(Arrays.toString(rsiIndicator.getValue())); // last 5 items based on timeFrame
        stock.setVolume(Arrays.toString(volIndicator.getValue())); // last 5 items based on timeFrame


        //stock.setVolume("65,54,42,87,69"); // last 5 items based on timeFrame
        //stock.setCandle("12,22,23,24;31,32,33,34;41,42,43,44;51,52,53,54"); // last 5 items based on timeFrame
        stock.setPriceAction(100);
        stock.setAiNews(100);
        stock.setSmartMoney(100);
        return stock;
    }

    @Override
    public Set<Stock> findAllByStrategyIdOrderByCreatedAtDesc(Long strategyId) {
        return stockRepository.findAllByStrategyIdOrderByCreatedAtDesc(strategyId);
    }

}
