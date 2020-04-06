package com.storyhasyou.example.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author fangxi
 * @date 2020/4/6
 */
@Slf4j
@RestController
@RequestMapping("/sleuth")
public class SleuthController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/traceA")
    public ResponseEntity<String> traceA() {
        log.info("-----------traceA");
        return restTemplate.getForEntity("http://eureka-client/client/hi", String.class);
    }

}
