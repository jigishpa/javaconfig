package com.senyume.javaconfig.controller;

import com.senyume.javaconfig.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jigish Patel
 */

@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;

	@RequestMapping("/hello")
	public String sayHello(){
		return helloService.sayHello();
	}
}
