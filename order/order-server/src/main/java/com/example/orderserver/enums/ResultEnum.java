package com.example.orderserver.enums;

import lombok.Getter;

/**
 * ResultEnum:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 20:08
 */
@Getter
public enum ResultEnum {
    SUCCESS(1, "成功"),
    FAIL(2, "失败"),;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
