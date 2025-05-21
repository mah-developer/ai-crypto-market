package com.ai_crypto_market.core.common.schedullers;

import com.ai_crypto_market.core.model.service.TradeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Scheduler responsible for triggering trading-related tasks at fixed intervals.
 */
@Component
public class MarketDataScheduler {

    private final TradeService tradeService;

    public MarketDataScheduler(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    /**
     * Handles open trading positions every 30 minutes.
     * fixedRate = 1800000 milliseconds (30 minutes)
     */
    @Scheduled(fixedRate = 1800000)
    public void handleOpenPositionsScheduledTask() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("[SCHEDULER] Handling open positions at " + now);
        try {
            tradeService.handleOpenPositions();
        } catch (Exception e) {
            System.err.println("[ERROR] Exception while handling open positions at " + now + ": " + e.getMessage());
        }
    }

    /**
     * Scans for new trading opportunities every 5 minutes.
     * fixedRate = 300000 milliseconds (5 minutes)
     */
    @Scheduled(fixedRate = 300000)
    public void handleNewOpportunitiesScheduledTask() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("[SCHEDULER] Scanning for new opportunities at " + now);
        try {
            tradeService.handleNewOpportunities();
        } catch (Exception e) {
            System.err.println("[ERROR] Exception while scanning for new opportunities at " + now + ": " + e.getMessage());
        }
    }
}
