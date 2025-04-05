package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.common.factories.ExchangeFactory;
import com.ai_crypto_market.core.common.factories.StrategyFactory;
import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.Wallet;
import com.ai_crypto_market.core.model.enums.ExchangeName;
import com.ai_crypto_market.core.model.enums.TradeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    private final PositionService positionService;
    private final StockService stockService;
    private final WalletService walletService;
    private final ExchangeFactory exchangeFactory;
    private final StrategyFactory strategyFactory;

    @Autowired
    public TradeServiceImpl(PositionService positionService,
                            StockService stockService,
                            WalletService walletService,
                            ExchangeFactory exchangeFactory,
                            StrategyFactory strategyFactory) {
        this.positionService = positionService;
        this.stockService = stockService;
        this.walletService = walletService;
        this.exchangeFactory = exchangeFactory;
        this.strategyFactory = strategyFactory;
    }

    @Override
    public void doTrade() {
        handleOpenPositions();
        handleNewOpportunities();
    }

    private void handleOpenPositions() {
        List<Position> openPositions = positionService.getOpenPositions();
        for (Position openedPosition : openPositions) {
            ExchangeName exchangeName = openedPosition.getWallet().getExchange().getExchangeName();
            ExchangeService exchangeService = exchangeFactory.getExchange(exchangeName);

            // Refresh position info from the exchange
            openedPosition = exchangeService.getPositionInfoFromExchangeServiceApi(openedPosition);

            // Enrich stock information
            Stock updatedStock = stockService.getFullStockInfoFromExternalServiceApi(openedPosition.getStrategy().getStock());
            openedPosition.getStrategy().setStock(updatedStock);

            // Analyze the position to determine the trade action
            Position analyzedPosition = positionService.analyze(openedPosition);

            // Execute the appropriate action based on the trade decision
            switch (analyzedPosition.getTradeAction()) {
                case BUY -> exchangeService.buy(analyzedPosition);
                case CLOSE -> exchangeService.sell(analyzedPosition);
                case CHANGETPSL -> positionService.changeTargetPriceAndStopLoss(analyzedPosition);
                default -> {
                    // Optional: Log unsupported or no-action cases here.
                }
            }
        }
    }

    private void handleNewOpportunities() {
        List<Wallet> activeWallets = walletService.getAllActiveWalletOrderByCreatedAtDesc();

        for (Wallet wallet : activeWallets) {
            ExchangeService exchangeService = exchangeFactory.getExchange(wallet.getExchange().getExchangeName());
            StrategyService strategyService = strategyFactory.getStrategy(wallet.getStrategy().getType());

            List<Stock> stocks = stockService.findAllByStrategyIdOrderByCreatedAtDesc(wallet.getStrategy().getId());
            for (Stock stock : stocks) {
                Stock fullStock = stockService.getFullStockInfoFromExternalServiceApi(stock);
                Position analyzedPosition = strategyService.analyzeNew(fullStock);
                if (TradeAction.BUY.equals(analyzedPosition.getTradeAction())) {
                    exchangeService.buy(analyzedPosition);
                }
            }
        }
    }
}