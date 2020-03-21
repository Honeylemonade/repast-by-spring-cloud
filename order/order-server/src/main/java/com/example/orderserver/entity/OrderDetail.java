package com.example.orderserver.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * OrderDetail:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 17:45
 */
@Data
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue
    private Integer detailId;

    /**
     * 订单id.
     */
    private Integer orderId;

    /**
     * 商品id.
     */
    private Integer productId;

    /**
     * 商品名称.
     */
    private String productName;

    /**
     * 商品单价.
     */
    private BigDecimal productPrice;

    /**
     * 商品数量.
     */
    private Integer productQuantity;

    /**
     * 商品小图.
     */
    private String productIcon;
}
