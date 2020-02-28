package com.storyhasyou.example.tcc.rabbitmq.controller;

import com.storyhasyou.example.tcc.rabbitmq.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@RestController
public class PayController {

    @Autowired
    private PayService payService;

    @PostMapping("/pay")
    public ResponseEntity<String> pay(Long userId, Long orderId, BigDecimal amount) {
        String pay = payService.pay(userId, orderId, amount);
        return ResponseEntity.ok(pay);
    }

}
