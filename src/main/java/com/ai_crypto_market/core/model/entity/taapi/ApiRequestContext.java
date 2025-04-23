package com.ai_crypto_market.core.model.entity.taapi;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import java.util.Map;


@Data
@Builder
public class ApiRequestContext<T> {
    private String baseUrl;
    private String path;
    private HttpMethod method;
    private Map<String, String> queryParams;
    private HttpHeaders headers;
    private T requestBody;
}
