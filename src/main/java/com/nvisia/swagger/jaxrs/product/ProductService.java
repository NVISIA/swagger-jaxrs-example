package com.nvisia.swagger.jaxrs.product;

/**
 * Service interface for products.
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
public interface ProductService {

   /**
    * Select product by ID
    * 
    * @param productId
    * @return
    * @throws Exception
    */
   Product getProduct(int productId) throws Exception;

}
