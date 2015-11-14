package com.nvisia.swagger.jaxrs.order;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.*;

/**
 * Order resource
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@Path("order")
@io.swagger.annotations.Api(value = "order")
public class OrderResource {

   @GET
   @Path("{orderId}")
   @Produces(MediaType.APPLICATION_JSON)
   @io.swagger.annotations.ApiOperation(value = "Find order by ID",
         notes = "Returns one order by ID", response = Order.class)
   @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 500,
               message = "An internal error occurred"),
         @io.swagger.annotations.ApiResponse(code = 404,
               message = "Order not found for ID") })
   public Order getOrder(@io.swagger.annotations.ApiParam(
         value = "Order ID to find by") @PathParam("orderId") int orderId) {
      OrderService orderService = new DefaultOrderService();
      Order order = null;
      try {
         order = orderService.getOrder(orderId);
      } catch (Exception e) {
         throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
               .type(MediaType.APPLICATION_JSON).build());
      }
      if (order == null) {
         throw new WebApplicationException(Response.status(Status.NOT_FOUND)
               .type(MediaType.APPLICATION_JSON).build());
      }

      return order;
   }

   @GET
   @Path("/")
   @Produces(MediaType.APPLICATION_JSON)
   @io.swagger.annotations.ApiOperation(value = "Find all orders",
         notes = "Returns all orders", response = List.class)
   @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 500,
               message = "An internal error occurred"),
         @io.swagger.annotations.ApiResponse(code = 404,
               message = "Order not found for ID") })
   public List<Order> getOrders() {
      OrderService orderService = new DefaultOrderService();
      List<Order> orders = null;
      try {
         orders = orderService.getAllOrders();
      } catch (Exception e) {
         throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
               .type(MediaType.APPLICATION_JSON).build());
      }
      if (orders == null) {
         throw new WebApplicationException(Response.status(Status.NOT_FOUND)
               .type(MediaType.APPLICATION_JSON).build());
      }

      return orders;
   }

   @POST
   @Path("submitOrder")
   @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
   @Produces(MediaType.APPLICATION_JSON)
   @io.swagger.annotations.ApiOperation(value = "Submit an order",
         notes = "Submits a new order", response = Order.class)
   @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 500,
               message = "An internal error occurred"),
         @io.swagger.annotations.ApiResponse(code = 404,
               message = "Order not found for ID"),
         @io.swagger.annotations.ApiResponse(code = 400,
               message = "Invalid order - no order items") })
   public Order submitOrder(
         @io.swagger.annotations.ApiParam("Order form with order details") OrderForm orderForm) {
      if (orderForm.getOrderItems() == null || orderForm.getOrderItems().isEmpty()) {
         throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
               .type(MediaType.APPLICATION_JSON).build());
      }

      OrderService orderService = new DefaultOrderService();
      Order order = null;
      try {
         order = orderService.submitOrder(orderForm.getCustomerId(),
               orderForm.getOrderItems(), new Date(System.currentTimeMillis()));
      } catch (Exception e) {
         throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
               .type(MediaType.APPLICATION_JSON).build());
      }

      if (order == null) {
         throw new WebApplicationException(Response.status(Status.NOT_FOUND)
               .type(MediaType.APPLICATION_JSON).build());
      }

      return order;
   }

}
