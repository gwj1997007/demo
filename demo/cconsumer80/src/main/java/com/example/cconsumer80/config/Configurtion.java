package com.example.cconsumer80.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configurtion {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
