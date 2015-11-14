package com.nvisia.swagger.jaxrs.customer;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.*;

import io.swagger.annotations.*;

/**
 * Customer resource
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@Path("customer")
@Api(value = "customer")
public class CustomerResource {

   @GET
   @Path("{customerId}")
   @Produces(MediaType.APPLICATION_JSON)
   @ApiOperation(value = "Find customer by ID", notes = "Returns one customerby ID",
         response = Customer.class)
   @ApiResponses(
         value = { @ApiResponse(code = 500, message = "An internal erroroccurred"),
               @ApiResponse(code = 404, message = "Customer not found for ID") })

   public Customer getCustomer(@ApiParam(
         value = "Customer ID to find by") @PathParam("customerId") int customerId) {
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
