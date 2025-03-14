package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.*;

import java.util.List;

public interface ExchangeService {
    String ExchangeInformation();
    String OpenPosition(Strategy strategy);
    String ClosePosition(Long amount);
    String GetBalance(Long amount);

    String openPosition(Wallet wallet, Strategy strategy);

    List<ExchangeStock> getAllExchangeStocks();

    MarketData fetchMarketData(ExchangeStock exchangeStock);

    Position buy(Position openedPosition);
    Position sell(Position openedPosition);
    Stock getFullStockInfoFromExchangeServiceApi(Stock stock);
    Long getPriceFromExchangeServiceApi(Position openedPosition);
    Long getProfitFromExchangeServiceApi(Position openPosition);
}
