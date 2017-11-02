package com.rudra.aks.hystrix.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HystrixProducerApp {

	public static void main(String args[]) {
		System.getProperties().put("server.port", 8088);
		SpringApplication.run(HystrixProducerApp.class, args);
	}
}
