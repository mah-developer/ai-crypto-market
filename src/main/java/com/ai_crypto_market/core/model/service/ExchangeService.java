package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.*;
import com.ai_crypto_market.core.model.enums.TimeFrame;

import java.util.List;

public interface ExchangeService {
    String ExchangeInformation();
    String GetBalance(Long amount);
    String GetProfit(Long amount);
    List<ExchangeStock> getAllExchangeStocks();
    MarketData fetchMarketData(ExchangeStock exchangeStock);

    Position openPosition(Position openedPosition);
    Position closePosition(Position openedPosition);
    Position closeAll(Position openedPosition);
    Stock getFullStockInfoFromExchangeServiceApi(Stock stock, TimeFrame timeframe);
    float getPriceFromExchangeServiceApi(Position openedPosition);
    float getProfitFromExchangeServiceApi(Position openPosition);
}
