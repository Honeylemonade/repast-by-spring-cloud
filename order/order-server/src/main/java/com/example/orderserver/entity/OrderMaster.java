package com.example.orderserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * OrderMaster:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 17:46
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderMaster {
    /**
     * 订单id.
     */
    @Id
    private Integer orderId;

    /**
     * 买家名字.
     */
    private String buyerName;

    /**
     * 买家手机号.
     */
    private String buyerPhone;

    /**
     * 买家微信Openid.
     */
    private String buyerId;

    /**
     * 订单总金额.
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认为0新下单.
     */
    private Integer orderStatus;

    /**
     * 支付状态, 默认为0未支付.
     */
    private Integer payStatus;
}
