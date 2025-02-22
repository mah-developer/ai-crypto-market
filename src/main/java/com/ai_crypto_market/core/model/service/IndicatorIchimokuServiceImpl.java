package com.ai_crypto_market.core.model.service;


import com.ai_crypto_market.core.model.entity.IndicatorIchimoku;
import com.ai_crypto_market.core.model.entity.IndicatorRSI;
import com.ai_crypto_market.core.model.entity.Stock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
@Qualifier("IndicatorichimokuService")
public class IndicatorIchimokuServiceImpl implements IndicatorService {
    public IndicatorIchimoku getCurrentSignal(Stock stock) {
        IndicatorIchimoku indicatorichi = new IndicatorIchimoku();
        indicatorichi.setName("Ichimoku");
        indicatorichi.setAccuracy(50);
        indicatorichi.setConversionLine(12.3f);

        return indicatorichi;
    }
}
