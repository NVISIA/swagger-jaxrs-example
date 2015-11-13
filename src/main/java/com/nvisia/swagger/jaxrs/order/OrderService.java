package com.nvisia.swagger.jaxrs.order;

import java.util.*;

/**
 * Service interface for orders
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
public interface OrderService {

   /**
    * Selects an order by order ID
    * 
    * @param orderId
    * @return
    */
   Order getOrder(int orderId) throws Exception;

   /**
    * Selects all orders
    * 
    * @return
    * @throws Exception
    */
   List<Order> getAllOrders() throws Exception;

   /**
    * Submits an order
    * 
    * @param customerId
    * @param orderItems
    * @param date
    * @return
    */
   Order submitOrder(int customerId, List<OrderItem> orderItems, Date date);

}
