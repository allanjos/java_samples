package br.com.olivum.java.spring;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("main()");

        // Get context

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        // Startup

        context.start();

        // Main flow

        System.out.println("Obtendo novo bean...");

        Product product = (Product) context.getBean("product");

        product.getName();

        product.setName("Produto de Teste");

        System.out.println("Obtendo novo bean...");

        product = (Product) context.getBean("product");

        product.getName();

        product.getProductParts();

        // Custom events

        CustomEventPublisher customEventPublisher = (CustomEventPublisher) context.getBean("customEventPublisher");

        customEventPublisher.publish();
        customEventPublisher.publish();

        // Database

        ProductJdbcTemplate productJdbcTemplate = (ProductJdbcTemplate) context.getBean("productJdbcTemplate");

        // Registering

        System.out.println("Registering products...");

        productJdbcTemplate.create(10, "iPhone X");
        productJdbcTemplate.create(11, "Moto Z");
        productJdbcTemplate.create(12, "Oculus Rift");

        // Listing

        System.out.println("Listing products...");

        List<Product> products = productJdbcTemplate.listProducts();

        for (Product p: products) {
            System.out.println("[Product] id=" + p.getId() + ", name=" + p.getName());
        }

        // Deletion

        System.out.println("Deleting previously registered products...");

        productJdbcTemplate.delete(10);
        productJdbcTemplate.delete(11);
        productJdbcTemplate.delete(12);

        // Listing

        System.out.println("Listing products...");

        products = productJdbcTemplate.listProducts();

        for (Product p: products) {
            System.out.println("[Product] id=" + p.getId() + ", name=" + p.getName());
        }

        // Termination

        context.registerShutdownHook();

        context.stop();

        context.close();
    }
}
