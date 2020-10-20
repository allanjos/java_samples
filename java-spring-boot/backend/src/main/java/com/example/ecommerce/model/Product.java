package com.example.ecommerce.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @GenericGenerator (
        name = "native",
        strategy = "native"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(unique=true)
    private String name;

    private double price;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
