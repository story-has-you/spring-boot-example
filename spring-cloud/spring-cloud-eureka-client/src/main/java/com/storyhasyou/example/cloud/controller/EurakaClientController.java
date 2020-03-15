package com.storyhasyou.example.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author fangxi
 * @date 2020/3/14
 */
@Slf4j
@RestController
@RequestMapping("/client")
public class EurakaClientController {

    @GetMapping("/hi")
    public ResponseEntity<String> hi() {
        return ResponseEntity.ok("Eureka Client");
    }

    @GetMapping("/retry")
    public ResponseEntity<String> retry(@RequestParam Long timeout) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(timeout);
        log.info("retry");
        return ResponseEntity.ok("retry");
    }

    @GetMapping("/error/{num}")
    public ResponseEntity<String> error(@PathVariable Integer num) {
        int i = 100 / num;
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/cache")
    public ResponseEntity<Map<String, Object>> cache() {
        log.info("cache!!!");
        Map<String, Object> map = new HashMap<>();
        map.put("abc", 123);
        map.put("def", 456);
        return ResponseEntity.ok(map);
    }
}
