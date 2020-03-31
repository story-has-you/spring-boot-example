package com.storyhasyou.example.boot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Table(name = "pay_msg")
@Entity
@Data
public class PayMsg implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Long id;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 0未成功，1发送成功，2超过最大的发送次数
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 最大的失败次数
     */
    @Column(name = "falure_cnt")
    private Integer falureCnt;

    /**
     * 创建时间
     */
    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime;


}
