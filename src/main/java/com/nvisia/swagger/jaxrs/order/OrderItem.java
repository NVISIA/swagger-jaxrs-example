package com.nvisia.swagger.jaxrs.order;

import javax.xml.bind.annotation.*;

/**
 * Order item type
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItem {

   private int orderItemId;
   private int orderedProductId;
   private double itemPrice;
   private boolean isInStock;

   /**
    * Blank constructor
    */
   public OrderItem() {

   }

   /**
    * Full constructor
    * 
    * @param orderItemId
    * @param orderedProductId
    * @param itemPrice
    * @param isInStock
    */
   public OrderItem(int orderItemId, int orderedProductId, double itemPrice,
         boolean isInStock) {
      super();
      this.orderItemId = orderItemId;
      this.orderedProductId = orderedProductId;
      this.itemPrice = itemPrice;
      this.isInStock = isInStock;
   }

   public int getOrderItemId() {
      return orderItemId;
   }

   public void setOrderItemId(int orderItemId) {
      this.orderItemId = orderItemId;
   }

   public int getOrderedProductId() {
      return orderedProductId;
   }

   public void setOrderedProductId(int orderedProductId) {
      this.orderedProductId = orderedProductId;
   }

   public double getItemPrice() {
      return itemPrice;
   }

   public void setItemPrice(double itemPrice) {
      this.itemPrice = itemPrice;
   }

   public boolean isInStock() {
      return isInStock;
   }

   public void setInStock(boolean isInStock) {
      this.isInStock = isInStock;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("OrderItem [orderItemId=").append(orderItemId)
            .append(", orderedProductId=").append(orderedProductId).append(", itemPrice=")
            .append(itemPrice).append(", isInStock=").append(isInStock).append("]");
      return builder.toString();
   }

}
