package com.senyume.javaconfig.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Jigish Patel
 */

// (see README.txt for detailed explanation)

// WebApplicationInitializer -->
// 		- interface in Servlet 3.0+ environments to configure ServletContext programmatically
// 		- this class is the equivalent of a web.xml file.
// 		- An implementation of this interface will be scanned by Spring on application startup and bootstrapped

public class AppInitializer implements WebApplicationInitializer {

	// add ContextLoaderListener and DispatcherServlet to ServletContext with onStartup() method
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		// Create the 'root' Spring application context
		// AnnotationConfigWebApplicationContext is a WebApplicationContext implementation that looks for Spring
		// configuration in classes annotated with @Configuration
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(ServiceConfig.class);

		// configure ContextLoaderListener (web.xml ContextLoaderListener equivalent). Manage the lifecycle of the root application context.
		servletContext.addListener(new ContextLoaderListener(rootContext));

		// Create the dispatcher servlet's Spring application context
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		dispatcherServlet.register(WebMvcConfig.class);

		// Register and map the dispatcher servlet (web.xml DispatcherServlet equivalent)
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(dispatcherServlet));
		dispatcher.setLoadOnStartup(1);

		// map /* to DispatcherServlet (web.xml <servlet-mapping> equivalent)
		dispatcher.addMapping("/*");
	}

}