package com.spring.resilience4j.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloWorldService {

    private final HelloWorldResilience helloWorldResilience;

    public String getHelloWorld() {
        return helloWorldResilience.getHelloWorld();
    }
}
