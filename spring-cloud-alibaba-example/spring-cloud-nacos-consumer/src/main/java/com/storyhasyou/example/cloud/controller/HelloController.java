package com.storyhasyou.example.cloud.controller;

import com.storyhasyou.example.cloud.feign.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author fangxi created by 2020/6/17
 */
@RestController
public class HelloController {

    @Autowired
    private  RestTemplate restTemplate;

    @Autowired
    private EchoService echoService;

    @GetMapping(value = "/echo/{str}")
    public String echo(@PathVariable String str) {
        // 使用服务名请求服务提供者
        return restTemplate.getForObject("http://service-provider/echo/" + str, String.class);
    }

    @GetMapping(value = "/feign/echo/{str}")
    public String echoFeign(@PathVariable String str) {
        // 使用服务名请求服务提供者
        return echoService.echo(str);
    }
}
