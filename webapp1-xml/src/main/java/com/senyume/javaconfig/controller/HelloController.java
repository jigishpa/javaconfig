package com.senyume.javaconfig.controller;

import com.senyume.javaconfig.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jigish Patel
 */

@Controller
public class HelloController {

	private HelloService helloService;

	public HelloService getHelloService() {
		return helloService;
	}

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}

	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello(){
		return helloService.sayHello();
	}
}
