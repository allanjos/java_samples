package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;

import java.util.List;

public interface ProductsService {
    public List<Product> getList();

    public Boolean saveProduct(Product product);

    public Boolean updateProduct(Product product);

    public Product getItem(long id);

    public Boolean deleteItem(long id);
}