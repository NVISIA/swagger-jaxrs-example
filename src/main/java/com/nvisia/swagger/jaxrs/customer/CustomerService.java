package com.nvisia.swagger.jaxrs.customer;

/**
 * Service interface for customer entity.
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
public interface CustomerService {

   /**
    * Selects a customer by customer ID.
    * 
    * @param customerId
    * @return Customer
    * @throws Exception
    */
   Customer getCustomer(int customerId) throws Exception;

}
