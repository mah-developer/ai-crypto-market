//package com.ai_crypto_market.core.model.service;
//
//import com.ai_crypto_market.core.model.entity.*;
//import com.ai_crypto_market.core.model.enums.ExchangeName;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@Qualifier("ExchangeCommonService")
//public class ExchangeServiceImpl implements ExchangeService {
//
//    @Autowired
//    @Qualifier("ExchangeBingXService")
//    private ExchangeService exchangeBingXService;
//
//    @Autowired
//    @Qualifier("ExchangeBinanceService")
//    private ExchangeService exchangeBinanceService;
//
//    private ExchangeService exchangeService;
//
//    private ExchangeService exchangeFactory(ExchangeName exchangeName) {
//        switch (exchangeName){
//            case BING_X:
//                return exchangeBingXService;
//            case BINANCE:
//                return exchangeBinanceService;
//            default:
//                return null;
//        }
//    }
//
//    public ExchangeServiceImpl() {
//        this.exchangeService = exchangeFactory(ExchangeName.BINANCE);
//    }
//
//    public ExchangeServiceImpl(ExchangeName exchangeName) {
//        this.exchangeService = exchangeFactory(exchangeName);
//    }
//
//    @Override
//    public String ExchangeInformation() {
//        return this.exchangeService.ExchangeInformation();
//    }
//
//    @Override
//    public String OpenPosition(Strategy strategy) {
//        return this.exchangeService.OpenPosition(strategy);
//    }
//
//    @Override
//    public String ClosePosition(Long amount) {
//        return this.exchangeService.ClosePosition(amount);
//    }
//
//    @Override
//    public String GetBalance(Long amount) {
//        return this.exchangeService.GetBalance(amount);
//    }
//
//    @Override
//    public String openPosition(Wallet wallet, Strategy strategy) {
//        return this.exchangeService.openPosition(wallet, strategy);
//    }
//
//    @Override
//    public List<ExchangeStock> getAllExchangeStocks() {
//        return this.exchangeService.getAllExchangeStocks();
//    }
//
//    @Override
//    public Position buy(Position openedPosition) {
//        return this.exchangeService.buy(openedPosition);
//    }
//
//    @Override
//    public Position sell(Position openedPosition) {
//        return this.exchangeService.sell(openedPosition);
//    }
//
//    @Override
//    public Stock getCandlestickDataFromExchangeServiceApi(Stock stock) {
//        return this.exchangeService.getCandlestickDataFromExchangeServiceApi(stock);
//    }
//
//    @Override
//    public Position getPositionInfoFromExchangeServiceApi(Position openedPosition) {
//        return this.exchangeService.getPositionInfoFromExchangeServiceApi(openedPosition);
//    }
//}
