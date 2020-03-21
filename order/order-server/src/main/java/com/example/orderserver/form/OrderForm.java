package com.example.orderserver.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * OrderForm:用于创建订单的API，前端发送过来的信息必须符合此格式
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 18:22
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;


    /**
     * 买家微信openid
     */
    @NotEmpty(message = "buyerId必填")
    private String buyerId;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
