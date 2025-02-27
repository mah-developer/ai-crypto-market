package com.ai_crypto_market.core.controller;

import com.ai_crypto_market.core.model.entity.Exchange;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.service.TradeDeciderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trade-decider")
public class TradeDeciderController {
    @Autowired
    private TradeDeciderService tradeDeciderService;

    @GetMapping("/strat")
    public String doTrade() {
        // attached object
        Stock stock = new Stock();
//        stock.setName("BTCUSD");
        Exchange exchange = new Exchange();
//        exchange.setName("binance");
//        stock.setExchange(exchange);
        System.out.println("trade executed on controller ...");
        return tradeDeciderService.doTrade(stock);
    }
}
