package com.fxipp.example.rabbitmq;

import com.fxipp.example.rabbitmq.entity.Order;
import com.fxipp.example.rabbitmq.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author fangxi
 * @date 2020/2/24
 */
@SpringBootTest
public class ShardingJdbcApplicationTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void save() {
        for (int i = 0; i < 40; i++) {
            Order order = new Order();
            order.setId((long) (i + 1));
            order.setStatus(1);
            order.setTotalAmout(new BigDecimal("100").add(new BigDecimal(String.valueOf(i))));
            order.setUserId(order.getId() + 1);
            orderMapper.insert(order);
        }
        /*Order order = new Order();
        order.setId(1L);
        order.setStatus(1);
        order.setTotalAmout(new BigDecimal("100").add(new BigDecimal("1")));
        order.setUserId(2L);
        orderMapper.insert(order);*/

    }

    @Test
    public void list() {
        List<Order> orders = orderMapper.list();
        orders.forEach(System.out::println);
    }

}
