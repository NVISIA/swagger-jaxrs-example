package com.nvisia.swagger.jaxrs.product;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.*;

/**
 * Product resource
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@Path("product")
public class ProductResource {

   @GET
   @Path("{productId}")
   @Produces(MediaType.APPLICATION_JSON)
   public Product getProduct(@PathParam("productId") int productId) {
      ProductService productService = new DefaultProductService();
      Product product = null;
      try {
         product = productService.getProduct(productId);
      } catch (Exception e) {
         throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
               .type(MediaType.APPLICATION_JSON).build());
      }
      if (product == null) {
         throw new WebApplicationException(Response.status(Status.NOT_FOUND)
               .type(MediaType.APPLICATION_JSON).build());
      }
      return product;
   }
}
