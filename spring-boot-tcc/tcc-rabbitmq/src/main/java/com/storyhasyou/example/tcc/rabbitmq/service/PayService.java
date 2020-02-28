package com.storyhasyou.example.tcc.rabbitmq.service;

import com.storyhasyou.example.tcc.rabbitmq.entity.User;
import com.storyhasyou.example.tcc.rabbitmq.repository.UserRepository;
import com.storyhasyou.example.tcc.rabbitmq.sender.RabbitSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Slf4j
@Service
public class PayService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RabbitSender rabbitSender;

    @Transactional(rollbackFor = Exception.class)
    public String pay(Long userId, Long orderId, BigDecimal amount) {
        // 扣余额
        User user = userRepository.getOne(userId);
        BigDecimal balance = user.getBalance();
        if (balance.compareTo(amount) < 0) {
            return "余额不足";
        }
        user.setBalance(balance.subtract(amount));
        userRepository.save(user);

        // 基于消息队列
        AtomicBoolean result = new AtomicBoolean(false);
        rabbitSender.send(orderId, "tcc", "tcc.payment",(correlationData, ack, cause) -> {
            if (!ack) {
                result.set(ack);
                // 发送失败
                log.error("消息发送失败: {}", cause);
            }
        });
        if (!result.get()) {
            throw new RuntimeException("send message fail");
        }
        return "success";
    }
}
