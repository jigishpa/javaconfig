JavaConfig for Web Applications:

Summary:

- Spring's WebApplicationInitializer interface can be implemented to configure a web application dynamically/programmatically.
- This implementation will be autodetected by a Servlet 3.0-compliant container and the WebApplicationInitializer's
  onStartup(...) method will be called during container startup.
- We implement WebApplicationInitializer interface and create root and web applicaton contexts in the onStartup(...) method
  (see webapp1-config module - config/AppInitializer class)
- We can also use the convenient AbstractAnnotationConfigDispatcherServletInitializer (an abstract base class for
  WebApplicationInitializer implementation that registers a DispatcherServlet configured with annotated classes)
  (see webapp1-config2 module - config/AppInitializer class)

Details:

Here are additional details about exactly what goes on behind the scenes and the mechanism by which WebApplicationInitializer
implementation is used to configure the web application.

javax.servlet.ServletContainerInitializer
(http://docs.oracle.com/javaee/7/api/javax/servlet/ServletContainerInitializer.html?is-external=true)

- Interface which allows a library/runtime to be notified of a web application's startup phase and perform any required
  programmatic registration of servlets, filters, and listeners in response to it.

org.springframework.web.SpringServletContainerInitializer
(http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/SpringServletContainerInitializer.html)

- designed to support code-based configuration of the servlet container using Spring's WebApplicationInitializer interface
- This class (WebApplicationInitializer implementation) will be loaded and instantiated and have its
        onStartup(java.util.Set<java.lang.Class<?>>, javax.servlet.ServletContext)
  method invoked by any Servlet 3.0-compliant container during container startup assuming that the spring-web module JAR
  is present on the classpath.
- When spring-web JAR is loaded, JAR API ServiceLoader.load(Class) will detect the META-INF/services/javax.servlet.ServletContainerInitializer
  service provider configuration file. This will cause the SpringServletContainerInitializer to be loaded and the
  onStartup(...) method to be invoked. This is how the root and web application contexts get registered along with filters, mappings, etc.

Service, ServiceProvider and JAR File Specification
(http://download.oracle.com/javase/6/docs/technotes/guides/jar/jar.html#Service%20Provider)

- A service is a well-known set of interfaces and (usually abstract) classes.
- A service provider is a specific implementation of a service.
- A  JAR file is essentially a zip file that contains an optional META-INF directory.
- A service provider identifies itself by placing a provider-configuration file in the resource directory META-INF/services
- The provider configuration file's name should consist of the fully-qualified name of the abstract service class
- The META-INF/services directory contains all the service provider configuration files and is are recognized and
  interpreted by the Java 2 Platform.

The chain of execution:

Container startup (for e.g. Tomcat startup)
    --> web application's spring-web JAR detected
        --> META-INF/services/javax.servlet.ServletContainerInitializer file detected
            --> this file contains the name of the implementation (org.springframework.web.SpringServletContainerInitializer)
                --> org.springframework.web.SpringServletContainerInitializer's onStartup(...) method called
                    AND container automatically scans all WebApplicationInitializer implementations and passes them on to the onStartup(...) method
                    --> each WebAplicationInitializer's onStartup(...) method called
                        --> root and web application contexts, filters, servlet mapping, etc configured inside this method