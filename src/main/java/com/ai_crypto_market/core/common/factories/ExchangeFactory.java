package com.ai_crypto_market.core.common.factories;

import com.ai_crypto_market.core.model.enums.ExchangeName;
import com.ai_crypto_market.core.model.service.ExchangeService;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ExchangeFactory {

    private final Map<ExchangeName, ExchangeService> exchangeMap = new EnumMap<>(ExchangeName.class);
/**
 * @implNote Each implementation of ExchangeService must implement a method like getExchangeName() that returns its associated enum value. The factory then auto-wires all such beans and builds an internal map for lookup.
 * */
    public ExchangeFactory(List<ExchangeService> exchangeServices) {
        // Auto-register each ExchangeService by its identifying ExchangeName
        for (ExchangeService service : exchangeServices) {
            exchangeMap.put(service.getExchangeName(), service);
        }
    }

    public ExchangeService getExchange(ExchangeName exchangeName) {
        return Optional.ofNullable(exchangeMap.get(exchangeName))
                .orElseThrow(() -> new IllegalArgumentException("No exchange service for: " + exchangeName));
    }
}
