package com.example.ecommerce.serviceimpl;

import java.util.List;
import java.util.Optional;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.repository.ProductsRepository;

@Service
class ProductsServiceImpl implements ProductsService {
   @Autowired
   ProductsRepository productsRepository;

   private static final Logger logger = Logger.getLogger(ProductsServiceImpl.class);

   public List<Product> getList() {
      logger.debug("getList()");

      return productsRepository.findAll();
   }

   public Boolean saveProduct(Product product) {
      logger.debug("saveProduct()");

      logger.debug("product: id=" + product.getId() + ", name=" + product.getName());

      productsRepository.save(product);

      return true;
   }

   public Boolean updateProduct(Product product) {
      logger.debug("updateProduct()");

      logger.debug("product: id=" + product.getId() + ", name=" + product.getName());

      Optional<Product> productToUpdate = productsRepository.findById(product.getId());

      if (!productToUpdate.isPresent()) {
         logger.error("Trying to update a nonexistent product record.");

         return false;
      }

      productsRepository.save(product);

      return true;
   }

   public Product getItem(long id) {
      logger.debug("getItem()");

      logger.debug("id: " + id);

      Optional<Product> product = productsRepository.findById(id);

      return product.isPresent() ? product.get() : null;
   }

   public Boolean deleteItem(long id) {
      logger.debug("deleteItem()");

      logger.debug("id: " + id);

      Optional<Product> product = productsRepository.findById(id);

      if (!product.isPresent()) {
         logger.debug("The product for ID " + id + " entry does not exist.");

         return false;
      }

      productsRepository.deleteById(id);

      product = productsRepository.findById(id);

      return product.isPresent() ? false : true;
   }
}