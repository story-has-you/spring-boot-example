package com.storyhasyou.example.ratelimiter.controller;

import com.storyhasyou.example.ratelimiter.annotation.AccessLimiter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author fangxi
 * @date 2020/2/29
 */
@RestController
public class RateLimiterController {

    @GetMapping("/limit")
    @AccessLimiter(limit = 10, timeout = 1, unit = TimeUnit.MINUTES)
    public ResponseEntity<Void> limit(String name) {
        return ResponseEntity.ok().build();
    }

}
