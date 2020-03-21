package com.example.orderserver.enums;

import lombok.Getter;

/**
 * PayStatusEnum:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 17:54
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
