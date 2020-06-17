package com.storyhasyou.example.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangxi
 * @date 2020/3/14
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private IService service;

    @GetMapping("/hi")
    public String hi() {
        return service.hi();
    }

    @GetMapping("/retry")
    public String retry(@RequestParam Long timeout) {
        return service.retry(timeout);
    }

}
