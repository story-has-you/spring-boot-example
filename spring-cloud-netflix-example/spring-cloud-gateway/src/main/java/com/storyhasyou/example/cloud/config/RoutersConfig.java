package com.storyhasyou.example.cloud.config;

import com.storyhasyou.example.cloud.filter.TimerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;

import java.time.ZonedDateTime;

/**
 * @author fangxi
 * @date 2020/4/1
 * @since 1.0.0
 */
@Configuration
public class RoutersConfig {

    @Autowired
    private TimerFilter timerFilter;

    @Bean
    @Order
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/java/**")
                        .and().method(HttpMethod.GET)
                        // header中如果有token这个name则放行
                        // .and().header("token")
                        // 当前时间之后一分钟生效
                        // .and().after(ZonedDateTime.now().plusMinutes(1))
                        .filters(f -> f.stripPrefix(1)
                                .filter(timerFilter)
                                .addResponseHeader("java-param", "gateway"))
                        .uri("lb://eureka-client")
                ).build();
    }


}
