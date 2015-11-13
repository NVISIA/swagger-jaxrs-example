package com.nvisia.swagger.jaxrs.order;

import java.util.*;

import javax.xml.bind.annotation.*;

/**
 * Order type
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

   private int orderId;
   private int orderCustomerId;
   private String orderNumber;
   private List<OrderItem> orderItems;
   private Date timeOrderPlaced;

   /**
    * Empty constructor
    */
   public Order() {

   }

   /**
    * Full constructor
    * 
    * @param orderId
    * @param orderCustomerId
    * @param orderNumber
    * @param orderItems
    * @param timeOrderPlaced
    */
   public Order(int orderId, int orderCustomerId, String orderNumber,
         List<OrderItem> orderItems, Date timeOrderPlaced) {
      super();
      this.orderId = orderId;
      this.orderCustomerId = orderCustomerId;
      this.orderNumber = orderNumber;
      this.orderItems = orderItems;
      this.timeOrderPlaced = timeOrderPlaced;
   }

   /**
    * @return the orderId
    */
   public int getOrderId() {
      return orderId;
   }

   /**
    * @param orderId
    *           the orderId to set
    */
   public void setOrderId(int orderId) {
      this.orderId = orderId;
   }

   /**
    * @return the orderCustomerId
    */
   public int getOrderCustomerId() {
      return orderCustomerId;
   }

   /**
    * @param orderCustomerId
    *           the orderCustomerId to set
    */
   public void setOrderCustomerId(int orderCustomerId) {
      this.orderCustomerId = orderCustomerId;
   }

   /**
    * @return the orderNumber
    */
   public String getOrderNumber() {
      return orderNumber;
   }

   /**
    * @param orderNumber
    *           the orderNumber to set
    */
   public void setOrderNumber(String orderNumber) {
      this.orderNumber = orderNumber;
   }

   /**
    * @return the orderItems
    */
   public List<OrderItem> getOrderItems() {
      return orderItems;
   }

   /**
    * @param orderItems
    *           the orderItems to set
    */
   public void setOrderItems(List<OrderItem> orderItems) {
      this.orderItems = orderItems;
   }

   /**
    * @return the timeOrderPlaced
    */
   public Date getTimeOrderPlaced() {
      return timeOrderPlaced;
   }

   /**
    * @param timeOrderPlaced
    *           the timeOrderPlaced to set
    */
   public void setTimeOrderPlaced(Date timeOrderPlaced) {
      this.timeOrderPlaced = timeOrderPlaced;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Order [orderId=").append(orderId).append(", orderCustomerId=")
            .append(orderCustomerId).append(", ");
      if (orderNumber != null) {
         builder.append("orderNumber=").append(orderNumber).append(", ");
      }
      if (orderItems != null) {
         builder.append("orderItems=").append(orderItems).append(", ");
      }
      if (timeOrderPlaced != null) {
         builder.append("timeOrderPlaced=").append(timeOrderPlaced);
      }
      builder.append("]");
      return builder.toString();
   }

}
