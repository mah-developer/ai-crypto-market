package com.ai_crypto_market.core.common.factories;

import com.ai_crypto_market.core.model.enums.StrategyType;
import com.ai_crypto_market.core.model.service.StrategyService;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class StrategyFactory {

    private final Map<StrategyType, StrategyService> strategyMap = new EnumMap<>(StrategyType.class);

    /**
     * @implNote
     * <p style="color:green; font-weight:bold;">
     *     Eeach implementation of {@link StrategyService} must provide its own strategy type (via a getStrategyType() method). The factory auto-discovers all such beans and builds a lookup map.
     *     </p>
     * */
    public StrategyFactory(List<StrategyService> strategyServices) {
        // Auto-register each StrategyService by its associated StrategyType
        for (StrategyService service : strategyServices) {
            strategyMap.put(service.getStrategyType(), service);
        }
    }

    public StrategyService getStrategy(StrategyType strategyType) {
        return Optional.ofNullable(strategyMap.get(strategyType))
                .orElseThrow(() -> new IllegalArgumentException("No strategy service for: " + strategyType));
    }
}
