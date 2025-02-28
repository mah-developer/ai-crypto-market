package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.Signal;
import com.ai_crypto_market.core.model.entity.User;
import com.ai_crypto_market.core.model.enums.StrategyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    @Qualifier("signalServiceFibonacci")
    private SignalService signalServiceFibonacci;


    @Autowired
    @Qualifier("signalServiceHoliday")
    private SignalService signalServiceHoliday;


    // Do Trade For specific Users
    public Signal doTrade(StrategyType strategyType, Stock stock, List<User> user) {
        SignalService signalService = strategyFactory(strategyType);

        Signal signal = new Signal();
//        trade.getId()

        return signal;
    }

    // Do Trade For All Users
    public Signal doTrade(StrategyType strategyType, Stock stock) {
        SignalService signalService = strategyFactory(strategyType);

        Signal signal = new Signal();
//        trade.getId()

        return signal;
    }


    private SignalService strategyFactory(StrategyType strategyType) {
        switch (strategyType) {
            case FIBONACCI:
                return signalServiceFibonacci;
                case HOLIDAY:
                    return signalServiceHoliday;
                    default:
                        return null;
        }
    }
}
