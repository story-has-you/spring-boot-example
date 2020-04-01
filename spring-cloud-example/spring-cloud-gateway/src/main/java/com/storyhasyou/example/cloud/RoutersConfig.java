package com.storyhasyou.example.cloud;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;

/**
 * @author fangxi
 * @date 2020/4/1
 * @since 1.0.0
 */
@Configuration
public class RoutersConfig {

    @Bean
    @Order
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/java/**")
                        .and().method(HttpMethod.GET)
                        // header中如果有token这个name则放行
                        .and().header("token")
                        .filters(f -> f.stripPrefix(1).addResponseHeader("java-param", "gateway"))
                        .uri("lb://spring-cloud-openfeign")
                ).build();
    }


}
