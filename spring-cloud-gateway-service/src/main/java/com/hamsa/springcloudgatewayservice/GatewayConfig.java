package com.hamsa.springcloudgatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * Adds routing info to the service. Country and Joke service
 * Techprimers- Spring cloug config with hystrix
 *
**/

@EnableHystrix
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()

                .route(p -> p
                .path("/all")
                .filters(f ->
                        f.addRequestHeader("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
                        .addRequestHeader("x-rapidapi-key", "1336cea56fmsh97cdbae0dad2645p12fc96jsn258636f9aa8f")
                        .hystrix(config -> config.setName("countries-service")
                        .setFallbackUri("forward:/countriesfallback")))
                .uri("https://restcountries-v1.p.rapidapi.com"))

                .route(p -> p
                        .path("/v1/joke")
                        .filters(f ->
                                f.addRequestHeader("x-rapidapi-host", "joke3.p.rapidapi.com")
                                 .addRequestHeader("x-rapidapi-key", "1336cea56fmsh97cdbae0dad2645p12fc96jsn258636f9aa8f")
                                 .hystrix(config -> config.setName("joke-service")
                                 .setFallbackUri("forward:/jokefallback")))
                        .uri("https://joke3.p.rapidapi.com"))

                .route(p -> p.
                        path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World" ))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.
                        host("*.hystrix.com")
                        .filters(f -> f.hystrix(config -> config.setName("mycmd")))
                        .uri("http://httpbin.org:80"))
                .build();
    }



}
