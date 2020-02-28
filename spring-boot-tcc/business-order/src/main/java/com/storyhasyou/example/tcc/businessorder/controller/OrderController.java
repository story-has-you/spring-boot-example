package com.storyhasyou.example.tcc.businessorder.controller;

import com.storyhasyou.example.tcc.businessorder.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/notify")
    public ResponseEntity<String> orderNotify(Long orderId) {
        log.info("回调触发: orderId: {}", orderId);
        String status = orderService.updateOrderStatus(orderId);
        return ResponseEntity.ok(status);
    }

}
