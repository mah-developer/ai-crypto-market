package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Wallet;
import com.ai_crypto_market.core.model.enums.StrategyType;
import com.ai_crypto_market.core.model.repository.PositionRepository;
import com.ai_crypto_market.core.model.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Override
    public List<Wallet> findAllByStrategyIdOrderByCreatedAtDesc(Long strategyId) {
        return walletRepository.findAllByStrategyIdOrderByCreatedAtDesc(strategyId);
    }

    @Override
    public List<Wallet> getAllActiveWalletOrderByCreatedAtDesc() {
        return walletRepository.getAllActiveWalletOrderByCreatedAtDesc();
    }

    @Override
    public List<Wallet> getWalletByExchangeIdOrderByCreatedAtDesc(Long strategyId) {
        return walletRepository.getWalletByExchangeIdOrderByCreatedAtDesc(strategyId);
    }

}
