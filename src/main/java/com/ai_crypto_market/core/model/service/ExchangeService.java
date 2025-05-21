package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.*;
import com.ai_crypto_market.core.model.enums.ExchangeName;

import java.util.List;

public interface ExchangeService {
    ExchangeName getExchangeName();
    String exchangeInformation();
    String openPosition(Strategy strategy);
    String closePosition(Long amount);
    String getBalance(Long amount);
    String openPosition(Wallet wallet, Strategy strategy);
    List<ExchangeStock> getAllExchangeStocks();
    Position buy(Position openedPosition);
    Position sell(Position openedPosition);
    Stock getCandlestickDataFromExchangeServiceApi(Stock stock);
    Position getPositionInfoFromExchangeServiceApi(Position openedPosition);

    int checkWeightStock(Stock stock);
}
