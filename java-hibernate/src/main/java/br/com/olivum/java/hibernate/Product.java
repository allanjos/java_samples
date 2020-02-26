package br.com.olivum.java.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "product")
@GenericGenerator(name = "id", strategy = "native")
public class Product {
    @Id
    @GeneratedValue(generator="id")
    @Column(name="id")
    private int id;
    private String name;

    String userMessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}