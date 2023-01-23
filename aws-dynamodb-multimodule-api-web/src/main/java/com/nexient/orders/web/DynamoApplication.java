package com.nexient.orders.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.nexient.orders"})
public class DynamoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamoApplication.class, args);
	}

}
