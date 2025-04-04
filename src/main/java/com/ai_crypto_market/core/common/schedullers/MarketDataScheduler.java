package com.ai_crypto_market.core.common.schedullers;

import com.ai_crypto_market.core.model.service.TradeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MarketDataScheduler {
    private final TradeService tradeService;

    public MarketDataScheduler(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @Scheduled(fixedRate = 30000)
    public void scheduled() {
        System.out.println("MarketDataScheduler scheduled at " + LocalDateTime.now());
        try {
            tradeService.doTrade();
        } catch (Exception e) {
            System.out.println("MarketDataScheduler- Error occurred during trading: " + e.getMessage());
        }
    }

}