package com.storyhasyou.example.boot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author fangxi
 * @date 2020/2/28
 */
@Table(name = "`order`")
@Data
@Entity
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 订单主键
     */
    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private Long id;

    /**
     * 下单人
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /**
     * 0未付款，1已付款，2已取消
     */
    @Column(name = "status", nullable = false)
    private Integer status;

    /**
     * 支付金额
     */
    @Column(name = "pay_amount", nullable = false)
    private BigDecimal payAmount;

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
