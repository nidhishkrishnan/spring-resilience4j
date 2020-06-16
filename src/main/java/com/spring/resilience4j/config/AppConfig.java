package com.spring.resilience4j.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

@Configuration
public class AppConfig {

    private static final String SERVICE_URL = "http://localhost:5050";

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler(SERVICE_URL);
        return builder
                .uriTemplateHandler(uriTemplateHandler)
                .build();
    }
}
