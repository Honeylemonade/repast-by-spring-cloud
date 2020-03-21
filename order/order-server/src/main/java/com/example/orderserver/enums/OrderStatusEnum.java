package com.example.orderserver.enums;

import lombok.Getter;

/**
 * OrderStatus:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 17:53
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
