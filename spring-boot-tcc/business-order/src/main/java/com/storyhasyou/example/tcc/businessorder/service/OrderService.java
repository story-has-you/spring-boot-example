package com.storyhasyou.example.tcc.businessorder.service;

import com.storyhasyou.example.tcc.businessorder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    /**
     * 订单回调
     */
    public String updateOrderStatus(Long orderId) {
        return Optional.of(orderRepository.getOne(orderId))
                .map(order -> {
                    order.setStatus(1);
                    orderRepository.save(order);
                    return "success";
                })
                .orElse("fail");
    }

}
