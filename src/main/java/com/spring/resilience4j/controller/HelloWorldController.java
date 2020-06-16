package com.spring.resilience4j.controller;

import com.spring.resilience4j.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @GetMapping("/hello-world")
    public String getHelloWorld() {
        return helloWorldService.getHelloWorld();
    }
}
