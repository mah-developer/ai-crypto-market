package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.Wallet;
import com.ai_crypto_market.core.model.repository.StockRepository;
import com.ai_crypto_market.core.model.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Override
    public Stock getFullStockInfoFromExternalServiceApi(Stock stock) {
        // previously filled these items: id, name, symbol
        stock.setRsi("39,32,43,65,80"); // last 5 items based on timeFrame
        stock.setMa7("20");
        stock.setMa14("35");
        stock.setMa21("45");
        //stock.setVolume("65,54,42,87,69"); // last 5 items based on timeFrame
        //stock.setCandle("12,22,23,24;31,32,33,34;41,42,43,44;51,52,53,54"); // last 5 items based on timeFrame
        stock.setPriceAction(50);
        stock.setAiNews(20);
        stock.setSmartMoney(21);
        return stock;
    }

    @Override
    public List<Stock> findAllByStrategyIdOrderByCreatedAtDesc(Long strategyId) {
        return stockRepository.findAllByStrategyIdOrderByCreatedAtDesc(strategyId);
    }

}
