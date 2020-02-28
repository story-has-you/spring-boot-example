package com.storyhasyou.example.atomikos.service;

import com.storyhasyou.example.atomikos.entity.Order;
import com.storyhasyou.example.atomikos.entity.User;
import com.storyhasyou.example.atomikos.mapper.order.OrderMapper;
import com.storyhasyou.example.atomikos.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Service
public class AtomikosService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public void save() {
        User user = new User(1L, "story-has-you");
        userMapper.insertSelective(user);
        // 模拟异常
        int i = 1 / 0;
        Order order = new Order(1L, new BigDecimal("100"), 1, 1L);
        orderMapper.insertSelective(order);
    }

}

