package com.ai_crypto_market.core.model.repository;


import com.ai_crypto_market.core.model.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}
