package br.com.olivum.java.spring;

public class ProductIdentification {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductIdentification() {
        System.out.println("ProductIdentication.ProductIdentication()");
    }
}
