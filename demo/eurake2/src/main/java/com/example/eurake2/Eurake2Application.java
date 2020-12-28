package com.example.provider.eurake2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eurake2Application {

	public static void main(String[] args) {
		SpringApplication.run(Eurake2Application.class, args);
	}

}
