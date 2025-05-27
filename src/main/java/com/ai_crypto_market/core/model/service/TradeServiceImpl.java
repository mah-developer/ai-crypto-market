package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.common.factories.ExchangeFactory;
import com.ai_crypto_market.core.common.factories.StrategyFactory;
import com.ai_crypto_market.core.model.entity.*;
import com.ai_crypto_market.core.model.enums.ExchangeName;
import com.ai_crypto_market.core.model.enums.MarketTrend;
import com.ai_crypto_market.core.model.enums.StrategyType;
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
            if (openedPosition.getStrategy() == null) {
                openedPosition.setStrategy(provideStrategyBasedOn(openedPosition));
            }
            ExchangeName exchangeName = openedPosition.getWallet().getExchange().getExchangeName();
            ExchangeService exchangeService = exchangeFactory.getExchange(exchangeName);

            // Refresh position info from the exchange
            openedPosition = exchangeService.getPositionInfoFromExchangeServiceApi(openedPosition);

            // Enrich stock information
            Stock fillStock = stockService.getFullStockInfoFromExternalServiceApiAndProvideMoreAnaliticInfoOfThisStock(openedPosition.getStock(),exchangeName,openedPosition.getStrategy().getTimeFrame());
            openedPosition.setStock(fillStock);
            //openedPosition.setStock(updatedStock);

            // Analyze the position to determine the trade action
            Position analyzedPosition = positionService.analyze(openedPosition);

            // Execute the appropriate action based on the trade decision
            switch (analyzedPosition.getTradeAction()) {
                case BUY -> exchangeService.openPosition(analyzedPosition);
                case CLOSE -> exchangeService.closePosition(analyzedPosition);
                case CHANGETPSL -> positionService.changeTargetPriceAndStopLoss(analyzedPosition);
                default -> {
                    // Optional: Log unsupported or no-action cases here.
                }
            }
        }
    }

    private Strategy provideStrategyBasedOn(Position openedPosition) {
        Strategy strategy = new Strategy();
        // todo -> find strategy based on strategy room
        strategy.setType(StrategyType.FIBONACCI);
        return strategy;
    }

    @Override
    public void handleNewOpportunities() {
        AppConfig appConfig = appConfigService.getAppConfig(); // todo: should load in first load as a global Bean
        List<Stock> stocks = stockService.findAll();

        //List<Stock> fullStocks = new ArrayList<>();

        MarketTrend marketTrend = calculateMarketTrend();
        stocks.forEach(stock -> {
            ExchangeService exchangeService = exchangeFactory.getExchange(appConfig.getdefaultExchangeCryptoName());
            Position newPosition=new Position();
            stock = exchangeService.getStockInfoFromExchangeServiceApi(stock,appConfig.getdefaultTimeFrameCrypto());
            stock = stockService.getFullStockInfoFromExternalServiceApiAndProvideMoreAnaliticInfoOfThisStock(stock,exchangeService.getExchangeName(),appConfig.getdefaultTimeFrameCrypto());
            newPosition.setStock(stock);

            List<Wallet> activeWallets = walletService.getAllActiveWalletOrderByCreatedAtDesc();
            for (Wallet wallet : activeWallets) {
                exchangeService = exchangeFactory.getExchange(wallet.getExchange().getExchangeName());
                wallet = exchangeService.getAvalableBalance(wallet);
                newPosition.setWallet(wallet);

                Position analyzedPosition = positionService.providePosition(newPosition, marketTrend);
                if (analyzedPosition.getTradeAction() == TradeAction.BUY) {
                    exchangeService.openPosition(analyzedPosition);
                }
            }
        });
    }

    private MarketTrend calculateMarketTrend() {
        // todo maybe calculate based on priceAction, history, news and etc.
        return MarketTrend.BULL;
    }


}