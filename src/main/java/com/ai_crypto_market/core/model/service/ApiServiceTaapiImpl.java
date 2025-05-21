package com.ai_crypto_market.core.model.service;

import com.ai_crypto_market.core.common.api.GenericApiClient;
import com.ai_crypto_market.core.model.entity.Position;
import com.ai_crypto_market.core.model.entity.Stock;
import com.ai_crypto_market.core.model.entity.taapi.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@Qualifier("apiServiceTaapi")
public class ApiServiceTaapiImpl implements ApiService {

    private final GenericApiClient apiClient;

    @Value("${taapi.io.api.key}")
    private String secret;

    @Value("${taapi.io.base.url}")
    private String baseUrl;

    @Value("${taapi.io.macd.path}")
    private String macdPath;

    @Value("${taapi.io.rsi.path}")
    private String rsiPath;

    @Value("${taapi.io.volume.path}")
    private String volPath;

    @Value("${taapi.io.bulk.path}")
    private String bulkPath;

    @Value("${taapi.io.manual.path}")
    private String manualPath;

    @Value("${taapi.io.sma.path}")
    private String smaPath;

    @Value("${taapi.io.ema.path}")
    private String emaPath;


    public ApiServiceTaapiImpl(GenericApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public MacdResponse getMacdIndicator(String exchange, String symbol, String interval) {
        Map<String, String> queryParams = Map.of(
                "secret", secret,
                "exchange", exchange,
                "symbol", symbol,
                "interval", interval
        );

        ResponseEntity<MacdResponse> response = apiClient.exchange(
                baseUrl,
                macdPath,
                HttpMethod.GET,
                queryParams,
                null,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

    // https://api.taapi.io/volume?secret=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbHVlIjoiNjA5MmNmY2M0MjI0NmNlM2IwZWNiYjI1IiwiaWF0IjoxNzQ2MjAwOTc0LCJleHAiOjMzMjUwNjY0OTc0fQ.yDldr9qdcTho7bwLDT8fuBH0xnEBtr7bKtE5tdzUzRE&exchange=binance&symbol=BTC/USDT&interval=1d&results=10
    public VolumeResponse getVolumeIndicator(String exchange, String symbol, String interval, int results) {
        // todo complete and refine
        Map<String, String> queryParams = Map.of(
                "secret", secret,
                "exchange", exchange,
                "symbol", symbol,
                "interval", interval,
                "results", String.valueOf(results)
        );

        ResponseEntity<VolumeResponse> response = apiClient.exchange(
                baseUrl,
                rsiPath,
                HttpMethod.GET,
                queryParams,
                null,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

    // https://api.taapi.io/rsi?secret=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbHVlIjoiNjA5MmNmY2M0MjI0NmNlM2IwZWNiYjI1IiwiaWF0IjoxNzQ2MjAwOTc0LCJleHAiOjMzMjUwNjY0OTc0fQ.yDldr9qdcTho7bwLDT8fuBH0xnEBtr7bKtE5tdzUzRE&exchange=binance&symbol=BTC/USDT&interval=1d&results=10
    public RsiResponse getRsiIndicator(String exchange, String symbol, String interval, int results) {
        // todo complete and refine
        Map<String, String> queryParams = Map.of(
                "secret", secret,
                "exchange", exchange,
                "symbol", symbol,
                "interval", interval,
                "results", String.valueOf(results)
        );
//        if (backTrack != null) {
//            queryParams.put("backtrack", backTrack);
//        }

        ResponseEntity<RsiResponse> response = apiClient.exchange(
                baseUrl,
                rsiPath,
                HttpMethod.GET,
                queryParams,
                null,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

    public BulkIndicatorResponse getBulkIndicators(String exchange, String symbol, String interval) {
        /*
        todo => check this https://taapi.io/documentation/integration/post-rest-bulk/
        the api key does not work for this service (face 401 un authorize)
        */


        Map<String, String> queryParams = Map.of(
                "secret", secret,
                "exchange", exchange,
                "symbol", symbol,
                "interval", interval
        );

        ResponseEntity<BulkIndicatorResponse> response = apiClient.exchange(
                baseUrl,
                bulkPath,
                HttpMethod.POST,
                queryParams,
                null,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

    public ManualAnalysisResponse getManualAnalysis(String exchange, String symbol, String interval, String indicators) {
        // TODO: IMPLEMENT => https://taapi.io/documentation/integration/manually/
       return null;
    }

    public HistoricalIndicatorResponse getHistoricalAnalysis(String exchange, String symbol, String interval, String indicator, int backtrack) {
        /**
         * todo: https://taapi.io/documentation/utilities/
         * */
        return null;
    }

    public SmaResponse getSmaIndicator(String exchange, String symbol, String interval, int period) {
        // todo complete and refine
        Map<String, String> queryParams = Map.of(
                "secret", secret,
                "exchange", exchange,
                "symbol", symbol,
                "interval", interval,
                "period", String.valueOf(period)
        );

        ResponseEntity<SmaResponse> response = apiClient.exchange(
                baseUrl,
                smaPath,
                HttpMethod.GET,
                queryParams,
                null,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

    public EmaResponse getEmaIndicator(String exchange, String symbol, String interval, int period) {
        // todo complete and refine
        Map<String, String> queryParams = Map.of(
                "secret", secret,
                "exchange", exchange,
                "symbol", symbol,
                "interval", interval,
                "period", String.valueOf(period)
        );

        ResponseEntity<EmaResponse> response = apiClient.exchange(
                baseUrl,
                emaPath,
                HttpMethod.GET,
                queryParams,
                null,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }


    public Object getExchangeInfo(String exchange, String symbol, String interval) {
        Map<String, String> queryParams = Map.of(
                "secret", secret,
                "exchange", exchange,
                "symbol", symbol,
                "interval", interval
        );

        ResponseEntity<Object> response = apiClient.exchange(
                baseUrl,
                macdPath,
                HttpMethod.GET,
                queryParams,
                null,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

    public Object getPositionInfoFromExchangeServiceApi(Position openedPosition) {
        Map<String, String> queryParams = Map.of(
                "name", "ali"
        );

        ResponseEntity<Object> response = apiClient.exchange(
                "binance.com",
                "/fapi/v3/positionRisk",
                HttpMethod.GET,
                queryParams,
                null,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }
}
