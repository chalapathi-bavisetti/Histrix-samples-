package com.rudra.aks.hystrix.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	private static Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@GetMapping("/get/{username}")
	public String	getMessage(@PathVariable("username") String username) {
		logger.info("Got call for message from user : " + username);
		
		return "Hello " + username + " !";
	}
}
