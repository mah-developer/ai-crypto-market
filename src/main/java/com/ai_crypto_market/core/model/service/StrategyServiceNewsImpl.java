package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.News;
import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.repository.NewsRepository;
import com.ai_crypto_market.core.model.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrategyServiceNewsImpl implements StrategyService {
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private StockRepository stockRepository;


    private Stock getStockForNews(News news) {
        // Map news to relevant stock (e.g., "USD Non-Farm Payroll" -> "EUR/USD")
        // This is simplistic; you'd need a mapping table or logic based on your markets
        String title = news.getTitle().toLowerCase();
//        todo bug fix
//        if (title.contains("usd") || title.contains("non-farm") || title.contains("fed")) {
//            return stockRepository.findBySymbol("EUR/USD")
//                    .orElseThrow(() -> new RuntimeException("Stock not found for news: " + news.getTitle()));
//        } else if (title.contains("btc") || title.contains("bitcoin")) {
//            return stockRepository.findBySymbol("BTC/USD")
//                    .orElseThrow(() -> new RuntimeException("Stock not found for news: " + news.getTitle()));
//        }
        throw new RuntimeException("No stock mapped for news: " + news.getTitle());
    }


    @Override
    public Position analyzeUpdate(Position position, Position newPosition, List<Position> positionHistoryBasedOnExchangeId) {
        return null;
    }

    @Override
    public Position analyzeNew(Stock stock) {
        return null;
    }

    @Override
    public void onInitialApplicationPersistDefaultStrategy() {

    }
}
