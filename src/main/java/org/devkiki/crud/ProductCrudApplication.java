package org.devkiki.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductCrudApplication {

    public static void main(String[] args) {
        System.out.println("SPRING_DATASOURCE_USERNAME: " + System.getenv("SPRING_DATASOURCE_USERNAME"));
        SpringApplication.run(ProductCrudApplication.class, args);
    }

}
