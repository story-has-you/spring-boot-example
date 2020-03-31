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
