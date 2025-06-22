package org.devkiki.crud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Nishimwe Rukundo Prosper",
                        email = "prosper.rk1@gmail.com"
                ),
                description = "API Documentation basic CRUD Operation and File uploading",
                title = "CRUD API Documentation",
                version = "v.1.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Render instance",
                        url = "https://crud-ymte.onrender.com"
                )
        }
)
@SpringBootApplication
public class ProductCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCrudApplication.class, args);
    }

}
