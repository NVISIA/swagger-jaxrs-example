package com.nvisia.swagger.jaxrs.customer;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.*;

/**
 * Customer resource
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@Path("customer")
public class CustomerResource {

   @GET
   @Path("{customerId}")
   @Produces(MediaType.APPLICATION_JSON)
   public Customer getCustomer(@PathParam("customerId") int customerId) {
      CustomerService customerService = new DefaultCustomerService();
      Customer customer = null;
      try {
         customer = customerService.getCustomer(customerId);
      } catch (Exception e) {
         throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
               .type(MediaType.APPLICATION_JSON).build());
      }
      if (customer == null) {
         throw new WebApplicationException(Response.status(Status.NOT_FOUND)
               .type(MediaType.APPLICATION_JSON).build());
      }
      return customer;
   }

}
