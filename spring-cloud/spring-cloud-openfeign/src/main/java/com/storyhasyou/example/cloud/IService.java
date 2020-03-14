package com.storyhasyou.example.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author fangxi
 * @date 2020/3/14
 */
@FeignClient(value = "eureka-client", path = "/client")
public interface IService {

    @GetMapping("/hi")
    String hi();

}
