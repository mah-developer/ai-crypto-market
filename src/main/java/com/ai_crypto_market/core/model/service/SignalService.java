package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Signal;
import com.ai_crypto_market.core.model.entity.Stock;

public interface SignalService {

//    Strategy analyze(Stock stock);
    Signal analyze(Stock stock);
    Signal analyze(String stock);
    Signal updatesignal(Stock stock);

    void updateSignal(Signal signal);
}
