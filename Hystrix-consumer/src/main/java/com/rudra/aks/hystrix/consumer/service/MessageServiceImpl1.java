package com.rudra.aks.hystrix.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rudra.aks.hystrix.consumer.MessageReceiverController;

@Service("fallback")
public class MessageServiceImpl1 implements MessageService {

	private static Logger logger = LoggerFactory.getLogger(MessageReceiverController.class);
	
	/**
	 * This is simple implementation of hystrix with only fallback logic.
	 */
	@HystrixCommand(fallbackMethod = "failedCall")
	public String showMessage(String username) {
		
		String result = new RestTemplate().getForObject("http://localhost:8088/get/"+username, String.class);
		return result;
	}

	/**
	 * This will be invoked by hystrix circuit breaker if call failed to annotated method
	 * 
	 * @param username
	 * @return default message
	 */
	public String failedCall(String username, Throwable t) {
		logger.error("Fall Back called for exception: " + t.getMessage());
		return "Hello " + "user !";
	}
	
	
	
}
