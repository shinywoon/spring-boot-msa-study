package com.example.apigatewayservice.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//@Configuration
public class FilterConfig {

    Environment env;

    public FilterConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(r -> r.path("/first-service/**")
                        .filters(f -> f.addRequestHeader("f-request","hello request")
                                .addResponseHeader("f-response","hello response"))
                        .uri("http://localhost:8081")
                )
                .route(r -> r.path("/second-service/**")
                        .filters(f -> f.addRequestHeader("s-request","hello request")
                                .addResponseHeader("s-response","hello response"))
                        .uri("http://localhost:8082")
                )
                .build();
    }

}
