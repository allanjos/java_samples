package br.com.olivum.java.spring;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class ProductJdbcTemplate implements ProductDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
       this.dataSource = dataSource;

       this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(int id, String name) {
       String sql = "INSERT INTO product (id, name) VALUES (?, ?)";

       jdbcTemplateObject.update(sql, id, name);

       System.out.println("Created record for product " + name + " with id=" + id);

       return;
    }

    @Override
    public Product getProduct(Integer id) {
       String sql = "SELECT * FROM product WHERE id = ?";

       Product product = jdbcTemplateObject.queryForObject(sql,
                                                           new Object[]{id},
                                                           new ProductMapper());

       return product;
    }

    @Override
    public List<Product> listProducts() {
       String sql = "SELECT * from product";

       List<Product> products = jdbcTemplateObject.query(sql, new ProductMapper());

       return products;
    }

    @Override
    public void delete(Integer id) {
       String sql = "DELETE FROM product WHERE id = ?";

       jdbcTemplateObject.update(sql, id);

       System.out.println("Deleted product record with ID = " + id);

       return;
    }

    @Override
    public void update(Integer id, String name){
       String sql = "UPDATE product SET name = ? WHERE id = ?";

       jdbcTemplateObject.update(sql, name, id);

       System.out.println("Updated product record with ID = " + id);

       return;
    }
 }
