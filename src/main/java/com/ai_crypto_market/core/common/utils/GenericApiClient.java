package com.ai_crypto_market.core.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.*;

import java.net.URI;
import java.util.Map;

@Component
public class GenericApiClient {

    private static final Logger logger = LoggerFactory.getLogger(GenericApiClient.class);
    private final RestTemplate restTemplate;

    public GenericApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T, R> ResponseEntity<R> exchange(
            String baseUrl,
            String path,
            HttpMethod method,
            Map<String, String> queryParams,
            T requestBody,
            Map<String, String> headers,
            ParameterizedTypeReference<R> responseType
    ) {
        try {
            String finalUrl = buildUrlWithParams(baseUrl + path, queryParams);

            HttpHeaders httpHeaders = new HttpHeaders();
            if (headers != null) {
                headers.forEach(httpHeaders::add);
            }

            HttpEntity<T> entity = new HttpEntity<>(requestBody, httpHeaders);
            logger.info("Calling API: {} {}", method, finalUrl);

            ResponseEntity<R> response = restTemplate.exchange(
                    URI.create(finalUrl),
                    method,
                    entity,
                    responseType
            );

            logger.info("API Response: Status = {}, Body = {}", response.getStatusCode(), response.getBody());
            return response;

        } catch (HttpClientErrorException | HttpServerErrorException ex) {
            logger.error("HTTP error while calling API: {} - {}", ex.getStatusCode(), ex.getResponseBodyAsString(), ex);
            throw ex;
        } catch (RestClientException ex) {
            logger.error("Error while calling API: {}", ex.getMessage(), ex);
            throw ex;
        }
    }

    private String buildUrlWithParams(String url, Map<String, String> queryParams) {
        if (queryParams == null || queryParams.isEmpty()) {
            return url;
        }

        StringBuilder sb = new StringBuilder(url);
        sb.append("?");
        queryParams.forEach((k, v) -> sb.append(k).append("=").append(v).append("&"));
        sb.setLength(sb.length() - 1); // remove trailing '&'
        return sb.toString();
    }
}
