package com.nvisia.swagger.jaxrs.config;

import javax.ws.rs.*;

import org.glassfish.jersey.server.*;

/**
 * Defines the components of the application.
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@ApplicationPath("services")
public class SwaggerJaxRsExampleApp extends ResourceConfig {

   public SwaggerJaxRsExampleApp() {
      packages("com.nvisia.swagger.jaxrs");
   }
}
