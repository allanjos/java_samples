package br.com.olivum.materials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = { "br.com.olivum.materials" })
@EnableJpaRepositories(basePackages = { "br.com.olivum.materials" })
@ComponentScan(basePackages = {"br.com.olivum.materials"})
public class Application {
    public static void main(String[] args) {
        System.out.println("main()");

        SpringApplication.run(Application.class, args);
    }
}