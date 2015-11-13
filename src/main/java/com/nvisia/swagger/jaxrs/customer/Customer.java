package com.nvisia.swagger.jaxrs.customer;

import java.util.*;

import javax.xml.bind.annotation.*;

/**
 * Customer type
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

   private int customerId;
   private String firstName;
   private String lastName;
   private Date customerSince;

   /**
    * Empty constructor
    */
   public Customer() {

   }

   /**
    * Full constructor
    * 
    * @param customerId
    * @param firstName
    * @param lastName
    * @param customerSince
    */
   public Customer(int customerId, String firstName, String lastName,
         Date customerSince) {
      super();
      this.customerId = customerId;
      this.firstName = firstName;
      this.lastName = lastName;
      this.customerSince = customerSince;
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
    * @return the firstName
    */
   public String getFirstName() {
      return firstName;
   }

   /**
    * @param firstName
    *           the firstName to set
    */
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   /**
    * @return the lastName
    */
   public String getLastName() {
      return lastName;
   }

   /**
    * @param lastName
    *           the lastName to set
    */
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   /**
    * @return the customerSince
    */
   public Date getCustomerSince() {
      return customerSince;
   }

   /**
    * @param customerSince
    *           the customerSince to set
    */
   public void setCustomerSince(Date customerSince) {
      this.customerSince = customerSince;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Customer [customerId=").append(customerId).append(", ");
      if (firstName != null) {
         builder.append("firstName=").append(firstName).append(", ");
      }
      if (lastName != null) {
         builder.append("lastName=").append(lastName).append(", ");
      }
      if (customerSince != null) {
         builder.append("customerSince=").append(customerSince);
      }
      builder.append("]");
      return builder.toString();
   }

}
