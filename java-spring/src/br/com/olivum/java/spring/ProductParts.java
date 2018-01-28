package br.com.olivum.java.spring;

import java.util.List;

public class ProductParts {
    List<String> partsList;

    public ProductParts() {
        System.out.println("ProductParts.ProductParts()");
    }

    public List<String> getPartsList() {
        System.out.println("ProductParts.getPartsList(): "  + partsList);

        return partsList;
    }

    public void setPartsList(List<String> partsList) {
        System.out.println("ProductParts.setPartsList(): "  + partsList);

        this.partsList = partsList;
    }
}
