package com.rudra.aks.hystrix.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rudra.aks.hystrix.consumer.MessageReceiverController;
import com.rudra.aks.hystrix.consumer.exception.CustomException;

@Service("ignoreException")
public class MessageServiceImpl3 implements MessageService {

	private static Logger logger = LoggerFactory.getLogger(MessageReceiverController.class);
	
	@HystrixCommand( fallbackMethod="failedCall", ignoreExceptions = CustomException.class )
	public String showMessage(String username) {
		
		if ("demo".equals(username.trim().toLowerCase()))
			throw new CustomException("dummy name passed");
		
		String result = new RestTemplate().getForObject("http://localhost:8088/get/"+username, String.class);
		return result;
	}
	

	public String failedCall(String username, Throwable t) {
		logger.error("Fall Back called for exception: " + t.getMessage());
		return "Hello " + "user !";
	}
}
