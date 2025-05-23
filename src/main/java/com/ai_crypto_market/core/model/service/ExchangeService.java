package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.*;
import com.ai_crypto_market.core.model.enums.ExchangeName;

import java.util.List;

public interface ExchangeService {
    ExchangeName getExchangeName();
    String exchangeInformation();
    String openPosition(Position position);
    String closePosition(Position position);
    String getAvalableBalance(Wallet wallet);
    Stock getCandleAndVolume(Stock stock);
    Position getPositionInfoFromExchangeServiceApi(Position openedPosition);
    Position getNewPositionInfoFromExchangeServiceApi(Position openedPosition);

    int checkWeightStock(Stock stock);
}
