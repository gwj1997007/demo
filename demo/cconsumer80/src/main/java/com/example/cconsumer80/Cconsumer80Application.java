package com.example.cconsumer80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Cconsumer80Application {
	public static void main(String[] args) {
		SpringApplication.run(Cconsumer80Application.class, args);
	}

}
