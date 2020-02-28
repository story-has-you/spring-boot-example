package com.storyhasyou.example.tcc.messagetable.service;

import com.storyhasyou.example.tcc.messagetable.entity.PayMsg;
import com.storyhasyou.example.tcc.messagetable.entity.User;
import com.storyhasyou.example.tcc.messagetable.repository.PayMsgRepository;
import com.storyhasyou.example.tcc.messagetable.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Service
public class PayService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PayMsgRepository payMsgRepository;

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

        // 存放消息到消息表
        PayMsg payMsg = new PayMsg();
        LocalDateTime now = LocalDateTime.now();
        payMsg.setOrderId(orderId);
        // 初始化未成功
        payMsg.setStatus(0);
        payMsg.setFalureCnt(0);
        payMsg.setCreateTime(now);
        payMsg.setUpdateTime(now);
        payMsgRepository.save(payMsg);
        return "success";
    }
}
