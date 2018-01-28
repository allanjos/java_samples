package br.com.olivum.java.spring;

public class Product {
    private int id;
    private String name;
    private ProductIdentification productIdentification;
    private ProductParts productParts;

    public void init() {
        System.out.println("Product.init()");
    }

    public void destroy() {
        System.out.println("Product.destroy()");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        System.out.println("Product.getName() name=" + name);

        return name;
    }

    public void setName(String name) {
        System.out.println("Product.setName() name=" + name);

        this.name = name;
    }

    public void setProductIdentification(ProductIdentification productIdentification) {
        this.productIdentification = productIdentification;
    }

    public ProductIdentification getProductIdentification() {
        return this.productIdentification;
    }

    public ProductParts getProductParts() {
        System.out.println("Product.getProductParts(): " + productParts.getPartsList());

        return productParts;
    }

    public void setProductParts(ProductParts productParts) {
        this.productParts = productParts;
    }
}
