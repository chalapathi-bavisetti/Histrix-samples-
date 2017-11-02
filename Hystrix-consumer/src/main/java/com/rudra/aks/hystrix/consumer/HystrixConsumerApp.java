package com.rudra.aks.hystrix.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class HystrixConsumerApp {

	public static void main(String args[]) {
		System.getProperties().put("server.port", 8077);
		SpringApplication.run(HystrixConsumerApp.class, args);
	}
}
