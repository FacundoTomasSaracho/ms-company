package com.facundosaracho.mscompany.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    private Info info() {
        return new Info()
                .title("Ms-Company")
                .description(
                        "Este microservicio permite manejar un CRUD de todo lo referido a clientes B2B (companies)")
                .version("1.0.0")
                .contact(LinkedIn());
    }

    private Contact LinkedIn() {
        return new Contact().name("LinkedIn").url("https://www.linkedin.com/in/facundo-tomas-saracho/");
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(info());
    }
}
