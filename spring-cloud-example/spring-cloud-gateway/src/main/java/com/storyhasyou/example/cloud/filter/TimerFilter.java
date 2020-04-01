package com.storyhasyou.example.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author fangxi
 * @date 2020/4/1
 * @since 1.0.0
 * 实现计时器的Filter
 */
@Slf4j
@Order(0)
@Component
public class TimerFilter implements GatewayFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(exchange.getRequest().getURI().getRawPath());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    stopWatch.stop();
                    log.info(stopWatch.prettyPrint());
                })
        );
    }
}
