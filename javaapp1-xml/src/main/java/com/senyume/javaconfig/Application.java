package com.senyume.javaconfig;

import com.senyume.javaconfig.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jigish Patel
 */
public class Application {

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloService service = (HelloService) context.getBean("hello");
		System.out.println("\nCalling hello(): " + service.sayHello());
	}
}
