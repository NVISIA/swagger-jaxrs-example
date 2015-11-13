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
public class OrderResource {

   @GET
   @Path("{orderId}")
   @Produces(MediaType.APPLICATION_JSON)
   public Order getOrder(@PathParam("orderId") int orderId) {
      OrderService orderService = new DefaultOrderService();
      Order order = null;
      try {
         order = orderService.getOrder(orderId);
      } catch (Exception e) {
         throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
               .type(MediaType.APPLICATION_JSON).build());
      }
      if (order == null) {
         throw new WebApplicationException(
               Response.status(Status.NOT_FOUND).type(MediaType.APPLICATION_JSON).build());
      }

      return order;
   }

   @GET
   @Path("/")
   @Produces(MediaType.APPLICATION_JSON)
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
         throw new WebApplicationException(
               Response.status(Status.NOT_FOUND).type(MediaType.APPLICATION_JSON).build());
      }

      return orders;
   }

   @POST
   @Path("submitOrder")
   @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
   @Produces(MediaType.APPLICATION_JSON)
   public Integer submitOrder(OrderForm orderForm) {
      if (orderForm.getOrderItems() == null || orderForm.getOrderItems().isEmpty()) {
         throw new WebApplicationException(
               Response.status(Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).build());
      }

      OrderService orderService = new DefaultOrderService();
      Order order = null;
      try {
         order = orderService.submitOrder(orderForm.getCustomerId(), orderForm.getOrderItems(),
               new Date(System.currentTimeMillis()));
      } catch (Exception e) {
         throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
               .type(MediaType.APPLICATION_JSON).build());
      }

      if (order == null) {
         throw new WebApplicationException(
               Response.status(Status.NOT_FOUND).type(MediaType.APPLICATION_JSON).build());
      }

      return order.getOrderId();
   }

}
