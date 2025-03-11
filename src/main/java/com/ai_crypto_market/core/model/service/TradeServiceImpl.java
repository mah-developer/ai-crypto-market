package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Signal;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.User;
import com.ai_crypto_market.core.model.entity.Wallet;
import com.ai_crypto_market.core.model.enums.SignalType;
import com.ai_crypto_market.core.model.enums.TradeStatus;
import com.ai_crypto_market.core.model.repository.SignalRepository;
import com.ai_crypto_market.core.model.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    @Qualifier("signalServiceFibonacci")
    private SignalService signalServiceFibonacci;


    @Autowired
    @Qualifier("signalServiceHoliday")
    private SignalService signalServiceHoliday;

    @Autowired
    private SignalRepository signalRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    @Qualifier("ExchangeBingXService")
    private ExchangeService exchangeService;

    public Signal doTrade(Wallet wallet, String marketFlow, SignalType signalType) {
        SignalService signalService = signalFactory(signalType);
        Signal signal = signalService.analyze(marketFlow);
        if (signal == null) return null;

        signal.setWallet(wallet);
        signal.setStatus(TradeStatus.PENDING);
        signal = signalRepository.save(signal);

        String positionId = exchangeService.openPosition(wallet, signal);
        signal.setPositionId(positionId);
        signal.setEntryPrice(signal.getEntryPrice()); // Entry price
        signal.setQuantity(calculateQuantity(wallet, signal));
        signal.setStatus(TradeStatus.OPEN);
        signal.setEntryTime(LocalDateTime.now());
        return signalRepository.save(signal);
    }

    private BigDecimal calculateQuantity(Wallet wallet, Signal signal) {
        return null;
    }


    // Do Trade For specific Users
    public Signal doTrade(SignalType strategyType, Stock stock, List<User> user) {
        SignalService signalService = signalFactory(strategyType);

        Signal signal = new Signal();
//        trade.getId()

        return signal;
    }

    // Do Trade For All Users
    public Signal doTrade(SignalType strategyType, Stock stock) {
        SignalService signalService = signalFactory(strategyType);

        Signal signal = new Signal();
//        trade.getId()

        return signal;
    }


    private SignalService signalFactory(SignalType strategyType) {
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
