package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Signal;
import com.ai_crypto_market.core.model.entity.Stock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("signalServiceFibonacci")
public class SignalServiceFibonacciImpl implements SignalService {

    @Override
    public Signal analyze(Stock stock) {
        return null;
    }

    @Override
    public Signal updatesignal(Stock stock) {
        return null;
    }

//    @Override
//    public Strategy analyze(Stock stock) {
//        Strategy strategy = new Strategy();
//        strategy.setStock(stock);
//        strategy.setType(StrategyType.FIBONACCI);
//        strategy.setBuyPercent(60.0);
//        strategy.setSellPercent(20.0);
//        // for example calculated trade action based on application config
//        strategy.setTradeAction(TradeAction.BUY);
//        return strategy;
//    }
}
