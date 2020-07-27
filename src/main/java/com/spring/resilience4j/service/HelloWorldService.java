package com.spring.resilience4j.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String getHelloWorld() {
        return "Hello World";
    }
}
