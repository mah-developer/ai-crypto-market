package com.ai_crypto_market.core.model.service;


import com.ai_crypto_market.core.model.entity.Indicator;
import com.ai_crypto_market.core.model.entity.Stock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
@Qualifier("ichimokuIndicatorService")
public class IchimokuIndicatorServiceImpl implements IndicatorService {
    public Indicator getCurrentSignal(Stock stock) {
        Indicator indicator = new Indicator();
        indicator.setName("Ichimoku");
        indicator.setAccuracy(50);
        indicator.setBuyPercent(10);
        indicator.setSellPercent(20);
        return indicator;
    }
}
