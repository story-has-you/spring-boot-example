package com.storyhasyou.example.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangxi
 * @date 2020/3/15
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private IService service;

    @GetMapping("/error/{num}")
    public String error(@PathVariable Integer num) {
        return service.error(num);
    }

    @GetMapping("/retry")
    public String retry(@RequestParam Long timeout) {
        return service.retry(timeout);
    }

}
