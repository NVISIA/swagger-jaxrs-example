package com.nvisia.swagger.jaxrs.product;

import javax.xml.bind.annotation.*;

/**
 * Product type
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

   private int productId;
   private String productName;
   private String sku;

   /**
    * Empty constructor
    */
   public Product() {

   }

   /**
    * Full constructor
    * 
    * @param productId
    * @param productName
    * @param sku
    */
   public Product(int productId, String productName, String sku) {
      super();
      this.productId = productId;
      this.productName = productName;
      this.sku = sku;
   }

   /**
    * @return the productId
    */
   public int getProductId() {
      return productId;
   }

   /**
    * @param productId
    *           the productId to set
    */
   public void setProductId(int productId) {
      this.productId = productId;
   }

   /**
    * @return the productName
    */
   public String getProductName() {
      return productName;
   }

   /**
    * @param productName
    *           the productName to set
    */
   public void setProductName(String productName) {
      this.productName = productName;
   }

   /**
    * @return the sku
    */
   public String getSku() {
      return sku;
   }

   /**
    * @param sku
    *           the sku to set
    */
   public void setSku(String sku) {
      this.sku = sku;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Product [productId=").append(productId).append(", ");
      if (productName != null) {
         builder.append("productName=").append(productName).append(", ");
      }
      if (sku != null) {
         builder.append("sku=").append(sku);
      }
      builder.append("]");
      return builder.toString();
   }

}
