package com.rudra.aks.hystrix.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rudra.aks.hystrix.consumer.service.MessageService;

@RestController
public class MessageReceiverController {

	private static Logger logger = LoggerFactory.getLogger(MessageReceiverController.class);
	
	@Autowired
	@Qualifier("fallback")
	MessageService	msgService1;
	
	@Autowired
	@Qualifier("commandKey")
	MessageService	msgService2;
	
	@Autowired
	@Qualifier("ignoreException")
	MessageService	msgService3;
	
	@Autowired
	@Qualifier("timeoutInterrupt")
	MessageService	msgService4;
	
	@Autowired
	@Qualifier("circuitBreaker")
	MessageService	msgService5;
	
	/***
	 * Calling showMessage() with hystrix support only as fallback.
	 * 
	 * @param username
	 * @return
	 */
	@GetMapping("/case1/show/{username}")
	public String	getMessage1(@PathVariable("username") String username) {
		logger.info("Calling message with hystrix support : " + username);
		return msgService1.showMessage(username);
	}
	
	/***
	 * Calling showMessage() with hystrix having ignoreExceptions.
	 * 
	 * @param username
	 * @return
	 */
	@GetMapping("/case2/show/{username}")
	public String	getMessage2(@PathVariable("username") String username) {
		logger.info("Calling message with hystrix support : " + username);
		return msgService2.showMessage(username);
	}
	
	/***
	 * Calling showMessage() with hystrix support only as fallback.
	 * 
	 * @param username
	 * @return
	 */
	@GetMapping("/case3/show/{username}")
	public String	getMessage3(@PathVariable("username") String username) {
		logger.info("Calling message with hystrix support : " + username);
		return msgService3.showMessage(username);
	}
	
	/***
	 * Calling showMessage() with hystrix support only as fallback.
	 * 
	 * @param username
	 * @return
	 */
	@GetMapping("/case4/show/{username}")
	public String	getMessage4(@PathVariable("username") String username) {
		logger.info("Calling message with hystrix support : " + username);
		return msgService4.showMessage(username);
	}
	
	/***
	 * Calling showMessage() with hystrix support only as fallback.
	 * 
	 * @param username
	 * @return
	 */
	@GetMapping("/case5/show/{username}")
	public String	getMessage5(@PathVariable("username") String username) {
		logger.info("Calling message with hystrix support : " + username);
		return msgService5.showMessage(username);
	}
	
}
