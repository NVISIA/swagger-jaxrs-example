package com.nvisia.swagger.jaxrs.customer;

import java.text.*;

/**
 * Default implementation for the customer service.
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
public class DefaultCustomerService implements CustomerService {

   @Override
   public Customer getCustomer(int customerId) throws Exception {
      Customer customer = null;
      SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
      if (customerId == 1) {
         customer = new Customer(1, "First", "Customer", format.parse("10/01/2015"));
      } else if (customerId == 2) {
         customer = new Customer(2, "Second", "Customer", format.parse("05/05/2013"));
      } else if (customerId == 3) {
         customer = new Customer(3, "Third", "Customer", format.parse("01/06/1999"));
      }

      return customer;
   }

}
