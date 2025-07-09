package com.abinator.urlshortener.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("URL Shortener API")
                .version("1.0.0")
                .description("A Redis-powered microservice for URL shortening with TTL, collision detection, and analytics")
                .contact(new Contact()
                    .name("URL Shortener Team")
                    .email("support@urlshortener.com")));
    }
}