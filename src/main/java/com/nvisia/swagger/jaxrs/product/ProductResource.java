package com.nvisia.swagger.jaxrs.product;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.*;

import io.swagger.annotations.*;

/**
 * Product resource
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@Path("product")
@Api(value = "product")
public class ProductResource {

   @GET
   @Path("{productId}")
   @Produces(MediaType.APPLICATION_JSON)
   @ApiOperation(value = "Find product by ID", notes = "Returns one productby ID",
         response = Product.class)
   @ApiResponses(
         value = { @ApiResponse(code = 500, message = "An internal erroroccurred"),
               @ApiResponse(code = 404, message = "Order not found for ID") })

   public Product getProduct(
         @ApiParam("Product ID to find by") @PathParam("productId") int productId) {
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
