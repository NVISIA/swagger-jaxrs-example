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

      register(io.swagger.jaxrs.listing.ApiListingResource.class);
      register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

      io.swagger.jaxrs.config.BeanConfig beanConfig = new io.swagger.jaxrs.config.BeanConfig();
      beanConfig.setSchemes(new String[] { "http" });
      beanConfig.setHost("localhost:8080");
      beanConfig.setBasePath("/swagger-jaxrs-example/services");
      beanConfig.setResourcePackage("com.nvisia.swagger.jaxrs");
      beanConfig.setScan(true);
      beanConfig.setPrettyPrint(true);

      io.swagger.models.Info info = new io.swagger.models.Info();
      io.swagger.models.Contact contact = new io.swagger.models.Contact();
      contact.setEmail("user@user.org");
      contact.setName("Michael Hoffman");
      contact.setUrl("http://www.nvisia.com");
      info.setContact(contact);
      info.setDescription("NVISIA Swagger JAX-RS Example");
      info.setTitle("swagger-jaxrs-example");
      info.setVersion("1.0");
      beanConfig.setInfo(info);
   }
}
