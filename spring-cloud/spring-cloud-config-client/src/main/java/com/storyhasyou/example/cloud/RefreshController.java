package com.storyhasyou.example.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangxi
 * @date 2020/3/31
 * @since 1.0.0
 * http://127.0.0.1:9007/actuator/refresh
 * 需要post请求这个方法，才会刷新配置
 */
@RestController
@RequestMapping("/reflash")
@RefreshScope
public class RefreshController {

    @Value("${config.name}")
    private String name;


    @GetMapping("/name")
    public ResponseEntity<String> getName() {
        return ResponseEntity.ok(name);
    }

}
