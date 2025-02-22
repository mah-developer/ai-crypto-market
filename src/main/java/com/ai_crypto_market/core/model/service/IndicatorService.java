package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Indicator;
import com.ai_crypto_market.core.model.entity.IndicatorIchimoku;
import com.ai_crypto_market.core.model.entity.IndicatorRSI;
import com.ai_crypto_market.core.model.entity.Stock;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;

public interface IndicatorService {
    Object getCurrentSignal(Stock stock);
}
