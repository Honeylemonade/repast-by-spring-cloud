package com.example.orderserver.dto;


import com.example.orderserver.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * OrderDTO:包含了主订单和订单详情
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 18:08
 */
@Data
public class OrderDTO {

    /** 订单id. */
    private Integer orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家微信Openid. */
    private String buyerId;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
