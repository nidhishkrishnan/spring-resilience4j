package com.spring.resilience4j.controller;

import com.spring.resilience4j.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @GetMapping("/hello-world")
    public String getHelloWorld(boolean enableRetry) {
        return helloWorldService.getHelloWorld(enableRetry);
    }


    @GetMapping("/sample-rest")
    public ResponseEntity sampleRest(boolean enableRetry) {
        if(enableRetry) {
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
