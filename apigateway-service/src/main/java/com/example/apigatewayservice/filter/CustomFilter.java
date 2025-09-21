package com.example.apigatewayservice.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {

    public CustomFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {
            // Custom Pre Filter
            log.info("Custom Pre Filter: request id -> {}", exchange.getRequest().getId());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // Custom Post Filter
                log.info("Custom Post Filter : response code -> {}", exchange.getResponse().getStatusCode());
            }));

        };

    }
    @Configuration
    public static class Config{

    }



}
