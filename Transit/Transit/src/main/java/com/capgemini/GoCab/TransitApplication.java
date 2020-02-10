package com.capgemini.GoCab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TransitApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransitApplication.class, args);
	}

}
