package com.ai_crypto_market.core.common.schedullers;

import com.ai_crypto_market.core.model.entity.ExchangeStock;
import com.ai_crypto_market.core.model.entity.ExchangeStockHistory;
import com.ai_crypto_market.core.model.entity.MarketData;
import com.ai_crypto_market.core.model.repository.ExchangeStockHistoryRepository;
import com.ai_crypto_market.core.model.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarketDataScheduler {
    @Autowired
    private ExchangeStockHistoryRepository historyRepository;
    @Qualifier("ExchangeBingXService")
    @Autowired private ExchangeService exchangeBingXService;

    @Scheduled(fixedRate = 300000) // 5 minutes
    public void persistMarketData() {
        List<ExchangeStock> exchangeStocks = exchangeBingXService.getAllExchangeStocks();
        for (ExchangeStock es : exchangeStocks) {
            MarketData data = exchangeBingXService.fetchMarketData(es);
            ExchangeStockHistory history = new ExchangeStockHistory();
            history.setExchangeStock(es);
            history.setOpenPrice(data.getOpen());
            history.setClosePrice(data.getClose());
            history.setHigh(data.getHigh());
            history.setLow(data.getLow());
            history.setVolume(data.getVolume());
            historyRepository.save(history);
        }
    }
}