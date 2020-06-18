package com.storyhasyou.example.cloud.controller;

import com.storyhasyou.example.cloud.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangxi created by 2020/6/18
 */
@RestController
public class HelloController {

    @Reference(version = "1.0.0")
    private HelloService helloService;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return helloService.echo(string);
    }
}
