package com.spring.resilience4j.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class HelloWorldGateway {

    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "hello-world", fallbackMethod = "fallbackForHelloWorld")
    public String getHelloWorld() {
        log.info("calling getHelloWorld()");
        return restTemplate.getForObject("/world", String.class);
    }

    public String fallbackForHelloWorld(Throwable t) {
        log.error("Inside fallbackForGetSeller, cause - {}", t.toString());
        return "Sorry ... Service not available!!!";
    }
}
