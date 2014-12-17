package com.senyume.javaconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Jigish Patel
 */

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.senyume.javaconfig.controller")		// for web-mvc beans
public class WebMvcConfig extends WebMvcConfigurerAdapter{
}
