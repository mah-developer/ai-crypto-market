package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Indicator;
import com.ai_crypto_market.core.model.entity.Stock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
@Qualifier("rsiIndicatorService")
public class RSIIndicatorServiceImpl implements IndicatorService {
    public Indicator getCurrentSignal(Stock stock) {
        Indicator indicator = new Indicator();
        indicator.setName("RSI");
        indicator.setAccuracy(40);
        indicator.setBuyPercent(5);
        indicator.setSellPercent(30);
        return indicator;
    }
}

