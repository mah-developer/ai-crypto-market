package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.*;
import com.ai_crypto_market.core.model.enums.ExchangeName;
import com.ai_crypto_market.core.model.enums.TimeFrame;

import java.util.List;

public interface ExchangeService {
    ExchangeName getExchangeName();
    String exchangeInformation();
    String openPosition(Position position);
    String closePosition(Position position);
    Wallet getAvalableBalance(Wallet wallet);
    Stock getCandleAndVolume(Stock stock);
    Position getPositionInfoFromExchangeServiceApi(Position openedPosition);
    Stock getStockInfoFromExchangeServiceApi(Stock stock, TimeFrame timeFrame);

    int checkWeightStock(Stock stock);
}
