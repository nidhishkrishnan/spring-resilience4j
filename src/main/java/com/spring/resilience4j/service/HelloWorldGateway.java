package com.spring.resilience4j.service;

import com.google.common.collect.Maps;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class HelloWorldGateway {

    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "hello-world")
    @Retry(name = "retry-service", fallbackMethod = "fallbackForHelloWorld")
    public String getHelloWorld(boolean enableRetry) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("enableRetry", enableRetry);
        return restTemplate.getForObject("/sample-rest?enableRetry={enableRetry}", String.class, params);
    }

    public String fallbackForHelloWorld(Throwable throwable) {
        log.error("Inside fallbackForGetSeller, cause - {}", throwable.toString());
        return "Sorry ... Service not available!!!";
    }
}
