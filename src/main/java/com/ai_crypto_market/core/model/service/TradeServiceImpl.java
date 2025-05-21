package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.common.factories.ExchangeFactory;
import com.ai_crypto_market.core.common.factories.StrategyFactory;
import com.ai_crypto_market.core.model.entity.AppConfig;
import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.Wallet;
import com.ai_crypto_market.core.model.enums.ExchangeName;
import com.ai_crypto_market.core.model.enums.MarketTrend;
import com.ai_crypto_market.core.model.enums.TradeAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    private final PositionService positionService;
    private final StockService stockService;
    private final WalletService walletService;
    private final ExchangeFactory exchangeFactory;
    private final StrategyFactory strategyFactory;
    private final AppConfigService appConfigService;

    @Autowired
    public TradeServiceImpl(PositionService positionService,
                            StockService stockService,
                            WalletService walletService,
                            ExchangeFactory exchangeFactory,
                            StrategyFactory strategyFactory,
                            AppConfigService appConfigService) {
        this.positionService = positionService;
        this.stockService = stockService;
        this.walletService = walletService;
        this.exchangeFactory = exchangeFactory;
        this.strategyFactory = strategyFactory;
        this.appConfigService = appConfigService;
    }

    @Override
    public void doTrade() {
        handleOpenPositions();
        handleNewOpportunities();
    }

    @Override
    public void handleOpenPositions() {
        List<Position> openPositions = positionService.getOpenPositions();

        for (Position openedPosition : openPositions) {
            ExchangeName exchangeName = openedPosition.getWallet().getExchange().getExchangeName();
            ExchangeService exchangeService = exchangeFactory.getExchange(exchangeName);

            // Refresh position info from the exchange
            openedPosition = exchangeService.getPositionInfoFromExchangeServiceApi(openedPosition);

            // Enrich stock information
            Stock updatedStock = stockService.getFullStockInfoFromExternalServiceApiAndProvideMoreAnaliticInfoOfThisStock(openedPosition.getStock());
            openedPosition.setStock(updatedStock);

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


    @Override
    public void handleNewOpportunities() {
        AppConfig appConfig = appConfigService.getAppConfig(); // todo: should load in first load as a global Bean
        List<Stock> stocks = stockService.findAll();
        List<Stock> fullStocks = new ArrayList<>();
        MarketTrend marketTrend = calculateMarketTrend();
        stocks.forEach(stock -> {
            Stock fullStock = stockService.getFullStockInfoFromExternalServiceApiAndProvideMoreAnaliticInfoOfThisStock(stock);
            List<Wallet> activeWallets = walletService.getAllActiveWalletOrderByCreatedAtDesc();
            for (Wallet wallet : activeWallets) {
                Position analyzedPosition = positionService.providePosition(fullStock, wallet, marketTrend);
                ExchangeService exchangeService = exchangeFactory.getExchange(wallet.getExchange().getExchangeName());
                if (analyzedPosition.getTradeAction() == TradeAction.BUY) {
                    exchangeService.buy(analyzedPosition);
                }
            }
        });
    }

    private MarketTrend calculateMarketTrend() {
        // todo maybe calculate based on priceAction, history, news and etc.
        return MarketTrend.BULL;
    }


}