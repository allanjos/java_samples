package br.com.olivum.java.spring;

import java.util.List;

import javax.sql.DataSource;

public interface ProductDAO {
    public void setDataSource(DataSource dataSource);

    public void create(int id, String name);

    public Product getProduct(Integer id);

    public List<Product> listProducts();

    public void delete(Integer id);

    public void update(Integer id, String name);
 }