package com.storyhasyou.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author fangxi
 * @date 2020/3/15
 */
// @EnableDiscoveryClient
// @SpringBootApplication
@EnableFeignClients
// @EnableCircuitBreaker
@SpringCloudApplication
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

}
