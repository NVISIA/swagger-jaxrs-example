package com.nvisia.swagger.jaxrs.product;

/**
 * Default product service implementation
 * 
 * @author Michael Hoffman, NVISIA
 *
 */
public class DefaultProductService implements ProductService {

   @Override
   public Product getProduct(int productId) throws Exception {
      Product product = null;
      if (productId == 1) {
         product = new Product(1, "Scissors", "1234A");
      } else if (productId == 2) {
         product = new Product(1, "Rock", "2234A");
      } else if (productId == 2) {
         product = new Product(1, "Paper", "9876A");
      }
      return product;
   }

}
