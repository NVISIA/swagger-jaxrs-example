package com.nvisia.swagger.jaxrs.config;

import javax.ws.rs.*;

import org.glassfish.jersey.server.*;

import io.swagger.jaxrs.config.*;

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

      register(io.swagger.jaxrs.listing.ApiListingResource.class);
      register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

      BeanConfig beanConfig = new BeanConfig();
      beanConfig.setVersion("1.0");
      beanConfig.setSchemes(new String[] { "http" });
      beanConfig.setHost("localhost:8080");
      beanConfig.setBasePath("/swagger-jaxrs-example/services");
      beanConfig.setResourcePackage("com.nvisia.swagger.jaxrs");
      beanConfig.setScan(true);
      beanConfig.setTitle("swagger-jaxrs-example");
      beanConfig.setDescription("NVISIA Swagger JAX-RS Example");
      beanConfig.setPrettyPrint(true);
   }
}
