package com.rudra.aks.hystrix.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.rudra.aks.hystrix.consumer.MessageReceiverController;

@Service("circuitBreaker")
public class MessageServiceImpl5 implements MessageService {

	private static Logger logger = LoggerFactory.getLogger(MessageReceiverController.class);
	
	@HystrixCommand(fallbackMethod = "failedCall", commandProperties={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
	public String showMessage(String username) {
		String result = new RestTemplate().getForObject("http://localhost:8088/get/"+username, String.class);
		return result;
	}
	

	public String failedCall(String username, Throwable t) {
		logger.error("Fall Back called for exception: " + t.getMessage());
		return "Hello " + "user !";
	}
}