package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.enums.StrategyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    @Qualifier("signalServiceFibonacci")
    private StrategyService strategyServiceFibonacci;

    @Autowired
    @Qualifier("signalServiceHoliday")
    private StrategyService strategyServiceHoliday;

    @Override
    public Position analyze(Position openedPosition) {
        StrategyService strategyService = strategyFactory(openedPosition.getStrategy().getType());
        return strategyService.analyze(openedPosition);
    }

    private StrategyService strategyFactory(StrategyType strategyType) {
        switch (strategyType) {
            case FIBONACCI:
                return strategyServiceFibonacci;
            case HOLIDAY:
                return strategyServiceHoliday;
            default:
                return null;
        }
    }

    public Position fillPositionObject(Position position) {
        Position newPosition = new Position();
        newPosition.setExchangePositionId(position.getExchangePositionId());
        newPosition.setStrategy(position.getStrategy());
        newPosition.setWallet(position.getWallet());
        newPosition.setCurrentTargetPrice(position.getCurrentTargetPrice());
        newPosition.setCurrentStopLoss(position.getCurrentStopLoss());
        newPosition.setEntryPrice(position.getEntryPrice());
        newPosition.setQuantity(position.getQuantity());
        newPosition.setPositionStatus(position.getPositionStatus());
        newPosition.setPositionType(position.getPositionType());
        newPosition.setProfit(position.getProfit());
        newPosition.setExchangePositionId(position.getExchangePositionId());
        newPosition.setCurrentPrice(position.getCurrentPrice());
        return newPosition;
    }

    public Stock getFullStockInfoFromExternalServiceApi(Stock stock) {
        // previously filled these items: id, name, symbol
        stock.setRsi("39,32,43,65,80"); // last 5 items based on timeFrame
        stock.setMa7("20");
        stock.setMa14("35");
        stock.setMa21("45");
        //stock.setVolume("65,54,42,87,69"); // last 5 items based on timeFrame
        //stock.setCandle("12,22,23,24;31,32,33,34;41,42,43,44;51,52,53,54"); // last 5 items based on timeFrame
        stock.setPriceAction(50);
        stock.setAiNews(20);
        stock.setSmartMoney(21);
        return stock;
    }

    public List<Position> getOpenPositions() {
        System.out.println("find and return openPositions ... ");
        List<Position> openPositions = new ArrayList<>();
        return openPositions;
    }

}
