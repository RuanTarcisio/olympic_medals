package com.rtarcisio.olympicgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes (RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(r -> r.path("/usuario/**")
                        .uri("lb://usuarios-ms"))
                .route(r -> r.path("/book-service/**")
                        .uri("lb://book-service"))
                .build();
    }
}
