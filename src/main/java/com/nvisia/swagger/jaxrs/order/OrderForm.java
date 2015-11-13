package com.nvisia.swagger.jaxrs.order;

import java.util.*;

import javax.xml.bind.annotation.*;

/**
 * Order form type
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderForm {

   private int customerId;
   private List<OrderItem> orderItems;

   /**
    * Empty constructor
    */
   public OrderForm() {

   }

   /**
    * Full constructor
    * 
    * @param customerId
    * @param timeOrderPlaced
    * @param orderItems
    */
   public OrderForm(int customerId, List<OrderItem> orderItems) {
      super();
      this.customerId = customerId;
      this.orderItems = orderItems;
   }

   /**
    * @return the customerId
    */
   public int getCustomerId() {
      return customerId;
   }

   /**
    * @param customerId
    *           the customerId to set
    */
   public void setCustomerId(int customerId) {
      this.customerId = customerId;
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

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("OrderForm [customerId=").append(customerId).append(", ");
      if (orderItems != null) {
         builder.append("orderItems=").append(orderItems);
      }
      builder.append("]");
      return builder.toString();
   }

}
