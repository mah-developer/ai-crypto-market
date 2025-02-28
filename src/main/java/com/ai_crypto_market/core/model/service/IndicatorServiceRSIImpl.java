package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.IndicatorRSI;
import com.ai_crypto_market.core.model.entity.Stock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
@Qualifier("IndicatorrsiService")
public class IndicatorServiceRSIImpl implements IndicatorService {
    public IndicatorRSI getCurrentSignal(Stock stock) {
        IndicatorRSI indicatorrsi = new IndicatorRSI();
        indicatorrsi.setName("RSI");
        indicatorrsi.setAccuracy(50);
        indicatorrsi.setRsiVal(45);
        indicatorrsi.setRsiMA(30.6f);
        return indicatorrsi;
    }
}

