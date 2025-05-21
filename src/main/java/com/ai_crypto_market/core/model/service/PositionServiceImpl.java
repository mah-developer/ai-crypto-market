package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.model.entity.*;
import com.ai_crypto_market.core.model.enums.MarketTrend;
import com.ai_crypto_market.core.model.enums.PositionType;
import com.ai_crypto_market.core.model.enums.StrategyType;
import com.ai_crypto_market.core.model.enums.TradeAction;
import com.ai_crypto_market.core.model.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    @Qualifier("strategyServiceFibonacci")
    private StrategyService strategyServiceFibonacci;

    @Autowired
    @Qualifier("signalServiceHoliday")
    private StrategyService strategyServiceHoliday;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    private AppConfigService appConfigService;

    @Override
    public Position analyze(Position openedPosition) {
        if (openedPosition.getStrategy() == null) {
            openedPosition.setStrategy(provideStrategyBasedOn(openedPosition));
        }
        StrategyService strategyService = strategyFactory(openedPosition.getStrategy().getType());
        List<Position> positionHistoryBasedOnExchangeId = findAllByExchangePositionIdOrderByCreatedAtDesc(openedPosition.getExchangePositionId());
        Position newPosition = fillPositionObject(openedPosition);
        return strategyService.analyzeUpdate(openedPosition, newPosition, positionHistoryBasedOnExchangeId);
    }

    private Strategy provideStrategyBasedOn(Position openedPosition) {
        Strategy strategy = new Strategy();
        // todo -> find strategy based on strategy room
        strategy.setType(StrategyType.FIBONACCI);
        return strategy;
    }


    @Override
    public Position changeTargetPriceAndStopLoss(Position openedPosition) {
        return null;
    }

    @Override
    public List<Position> findAllByExchangePositionIdOrderByCreatedAtDesc(String exchangePositionId) {
        return positionRepository.findAllByExchangePositionIdOrderByCreatedAtDesc(exchangePositionId);
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

    @Override
    public List<Position> getOpenPositions() {
        System.out.println("find and return openPositions ... ");
        List<Position> openPositions = new ArrayList<>();
        return openPositions;
    }

    @Override
    public Position providePosition(Stock stock, Wallet wallet, MarketTrend marketTrend) {
        Position position = new Position();
        position.setPositionType(calculatePositionTypeBasedOn(stock, marketTrend));
        position.setTradeAction(calculateTradeAction(position.getPositionType()));
        position.setQuantity(calculateQuantityBasedOn(wallet));
        //...

        return position;
    }

    private TradeAction calculateTradeAction(PositionType positionType) {
        if (positionType.equals(PositionType.NONE)) {
            return TradeAction.NONE;
        } else {
            return TradeAction.BUY;
        }
    }

    private BigDecimal calculateQuantityBasedOn(Wallet wallet) {
        AppConfig appConfig = appConfigService.getAppConfig();
        int defaultPercentOfAvailablePerCryptoPosition = appConfig.getDefaultPercentOfAvailablePerCryptoPosition();
        BigDecimal maxPercentOfAvailablePerPosition = wallet.getMaxPercentOfAvailablePerPosition();
        BigDecimal availableBalance = wallet.getAvailableBalance();
        BigDecimal result = new BigDecimal(0);
        return result;
    }

    private PositionType calculatePositionTypeBasedOn(Stock stock, MarketTrend marketTrend) {
        // todo calculate position type based on stock's indicators and market trend
        // todo we need to find the market trend and after that set the PositionType
        //  if
        //  Ascending (Bear) -> PositionType.SHORT
        //  Descending (Cow) -> PositionType.LONG
        return PositionType.LONG;
    }

}
