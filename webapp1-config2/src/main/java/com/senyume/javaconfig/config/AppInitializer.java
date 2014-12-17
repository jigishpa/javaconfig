package com.senyume.javaconfig.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Jigish Patel
 */

// (see README.txt for detailed explanation)

// WebApplicationInitializer -->
// 		- interface in Servlet 3.0+ environments to configure ServletContext programmatically
// 		- this class is the equivalent of a web.xml file.
// 		- An implementation of this interface will be scanned by Spring on application startup and bootstrapped

// AbstractAnnotationConfigDispatcherServletInitializer -->
// 		- is an abstract base class for WebApplicationInitializer implementations that register a DispatcherServlet
// 		  configured with annotated classes
//		- is a convenience abstract class that creates necessary contexts and registers them for us
//		- replaces the need to implement WebApplicationInitializer

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// provide configuration that will go in the root application context (service tier - usually data source, threadpool,
	//																		transaction managers, thread pools, dao, etc.)
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { ServiceConfig.class };
	}

	// provide configuration that will go in the web application context (web tier - usually controllers)
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebMvcConfig.class };
	}

	// servlet mappings for DispatcherServlet (for e.g. "/", "/app", etc.)
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// servlet filters and other customizations are done by overriding methods of AbstractDispatcherServletInitializer

}