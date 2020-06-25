package com.spring.resilience4j.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloWorldService {

    private final HelloWorldGateway helloWorldGateway;

    public String getHelloWorld() {
        return helloWorldGateway.getHelloWorld();
    }
}
