package com.storyhasyou.example.boot.notify;

import com.storyhasyou.example.boot.entity.PayMsg;
import com.storyhasyou.example.boot.repository.PayMsgRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Slf4j
@Component
public class OrderScheduler {

    @Autowired
    private PayMsgRepository payMsgRepository;
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 回调地址，写死了吧
     */
    public static final String URL = "http://localhost:8081/order/notify";

    /**
     * 定时任务，10秒一次请求回调接口
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void orderNotify() {
        List<PayMsg> payMsgList = payMsgRepository.findByStatus(0);
        if (CollectionUtils.isEmpty(payMsgList)) {
            return;
        }
        payMsgList.forEach(payMsg -> {
            String result = restTemplate.postForObject(URL + "?orderId=" + payMsg.getOrderId(), null, String.class);
                    if ("success".equals(result)) {
                        payMsg.setStatus(1);
                        log.info("success");
                    } else {
                        Integer falureCnt = payMsg.getFalureCnt();
                        if (++falureCnt > 5) {
                            payMsg.setStatus(2);
                        }
                        payMsg.setFalureCnt(falureCnt);
                        log.error("fail, falureCnt: {}", falureCnt);
                    }
                    payMsgRepository.save(payMsg);
                });

    }

}
