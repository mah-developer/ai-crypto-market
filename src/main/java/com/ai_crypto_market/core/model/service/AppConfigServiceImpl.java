package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.AppConfig;
import com.ai_crypto_market.core.model.repository.AppConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppConfigServiceImpl implements AppConfigService {

    @Autowired
    private AppConfigRepository appConfigRepository;

    @Override
    public AppConfig getAppConfig() {
        return appConfigRepository.findAll().getFirst();
    }
}
