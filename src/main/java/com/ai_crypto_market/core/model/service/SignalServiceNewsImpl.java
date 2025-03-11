package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.News;
import com.ai_crypto_market.core.model.entity.Signal;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.enums.TradeAction;
import com.ai_crypto_market.core.model.repository.NewsRepository;
import com.ai_crypto_market.core.model.repository.StockRepository;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class SignalServiceNewsImpl implements SignalService {
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Signal analyze(Stock stock) {
        News news = newsRepository.findNextHighImpactNews();
        if (news == null || news.getPublishTime().isAfter(LocalDateTime.now().plusMinutes(1))) return null;

        Signal buySignal = new Signal();
        buySignal.setStock(getStockForNews(news));
        // todo bug fix, expect 2 args but gives one
//        buySignal.setPrice(getCurrentPrice(buySignal.getStock()).add("15", ));
        buySignal.setTradeAction(TradeAction.BUY);
        buySignal.setStopLoss(buySignal.getEntryPrice().subtract(BigDecimal.valueOf(30)));
        buySignal.setTargetPrice(buySignal.getEntryPrice().add(BigDecimal.valueOf(30)));

        Signal sellSignal = new Signal();
        sellSignal.setStock(buySignal.getStock());
        // todo bug fix
//        sellSignal.setPrice(getCurrentPrice(sellSignal.getStock()).subtract(BigDecimal.valueOf(15)));
        sellSignal.setTradeAction(TradeAction.SELL);
        sellSignal.setStopLoss(sellSignal.getEntryPrice().add(BigDecimal.valueOf(30)));
        sellSignal.setTargetPrice(sellSignal.getEntryPrice().subtract(BigDecimal.valueOf(30)));

        scheduleClosePendingOrders(news.getPublishTime().plusMinutes(1), buySignal, sellSignal);
        return buySignal; // Return one, handle the other in scheduler
    }

    private void scheduleClosePendingOrders(LocalDateTime localDateTime, Signal buySignal, Signal sellSignal) {
        // todo provide body
    }

    private MutablePropertyValues getCurrentPrice(Stock stock) {
        // todo provide body
            return null;
    }

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
    public Signal analyze(String stock) {
        return null;
    }

    @Override
    public Signal updatesignal(Stock stock) {
        return null;
    }

    @Override
    public void updateSignal(Signal signal) {

    }
}
