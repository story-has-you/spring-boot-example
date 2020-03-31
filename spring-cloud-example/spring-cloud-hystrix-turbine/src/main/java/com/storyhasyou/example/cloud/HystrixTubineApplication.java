package com.storyhasyou.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author fangxi
 * @date 2020/3/17
 * http://127.0.0.1:9005/turbine.stream 访问查看监控信息
 */
@EnableDiscoveryClient
@EnableHystrix
@EnableTurbine
@SpringBootApplication
public class HystrixTubineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTubineApplication.class, args);
    }

}
