package com.senyume.javaconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jigish Patel
 */

@Configuration
@ComponentScan(basePackages = "com.senyume.javaconfig.service")		// for generic non-mvc beans
public class ServiceConfig {

}
