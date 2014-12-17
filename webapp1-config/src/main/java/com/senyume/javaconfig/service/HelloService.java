package com.senyume.javaconfig.service;

import org.springframework.stereotype.Service;

/**
 * @author Jigish Patel
 */

@Service
public class HelloService {

	public String sayHello(){
		return "Hello World from web application!";
	}
}
