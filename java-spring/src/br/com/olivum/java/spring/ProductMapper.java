package br.com.olivum.java.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
       Product product = new Product();
       product.setId(rs.getInt("id"));
       product.setName(rs.getString("name"));

       return product;
    }
}