package com.ai_crypto_market.core.common.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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
            URI uri = buildUri(baseUrl, path, queryParams);
            HttpHeaders httpHeaders = buildHeaders(headers);

            HttpEntity<T> entity = (requestBody != null)
                    ? new HttpEntity<>(requestBody, httpHeaders)
                    : new HttpEntity<>(httpHeaders);

            logger.info("Calling API [{}]: {}", method, uri);

            ResponseEntity<R> response = restTemplate.exchange(
                    uri,
                    method,
                    entity,
                    responseType
            );

            logger.info("API Response [{}]: Status = {}, Body = {}", method, response.getStatusCode(), response.getBody());
            return response;

        } catch (HttpClientErrorException | HttpServerErrorException ex) {
            logger.error("HTTP error while calling API: [{}] {} - {}", method, ex.getStatusCode(), ex.getResponseBodyAsString(), ex);
            throw ex;
        } catch (RestClientException ex) {
            logger.error("Client error while calling API [{}]: {}", method, ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            logger.error("Unexpected error while calling API [{}]: {}", method, ex.getMessage(), ex);
            throw new RuntimeException("Unexpected error while calling external API", ex);
        }
    }

    private URI buildUri(String baseUrl, String path, Map<String, String> queryParams) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(baseUrl + (path != null ? path : ""));

        if (queryParams != null) {
            queryParams.forEach(builder::queryParam);
        }

        URI uri = builder.build(true).toUri();
        logger.debug("Built URI: {}", uri);
        return uri;
    }

    private HttpHeaders buildHeaders(Map<String, String> headers) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        if (headers != null) {
            headers.forEach(httpHeaders::add);
        }

        return httpHeaders;
    }
}
