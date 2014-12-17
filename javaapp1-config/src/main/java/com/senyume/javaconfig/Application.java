package com.senyume.javaconfig;

import com.senyume.javaconfig.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jigish Patel
 */

@Configuration										// indicates that its primary purpose is as a source of bean definitions
@ComponentScan(basePackages = "com.senyume.javaconfig.service")	// to autodetect classes and register the corresponding beans
public class Application {

	public static void main(String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		HelloService helloService = (HelloService) context.getBean("helloService");
		System.out.println("\nCalling hello(): " + helloService.sayHello());
	}
}
