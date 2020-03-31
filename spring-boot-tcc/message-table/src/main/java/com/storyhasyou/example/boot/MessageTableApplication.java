package com.storyhasyou.example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@SpringBootApplication
@EnableScheduling
public class MessageTableApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageTableApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
