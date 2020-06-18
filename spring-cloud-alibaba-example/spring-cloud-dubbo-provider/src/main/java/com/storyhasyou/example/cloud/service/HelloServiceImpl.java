package com.storyhasyou.example.cloud.service;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author fangxi created by 2020/6/18
 */
@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {

    @Override
    public String echo(String string) {
        return "Echo Hello Dubbo " + string;
    }

}
