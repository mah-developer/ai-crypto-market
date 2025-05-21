package com.ai_crypto_market.core.model.repository;

import com.ai_crypto_market.core.model.entity.AppConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppConfigRepository extends JpaRepository<AppConfig, Integer> {

}
