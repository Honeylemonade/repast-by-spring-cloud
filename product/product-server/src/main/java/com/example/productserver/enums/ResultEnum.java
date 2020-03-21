package com.example.productserver.enums;

import lombok.Getter;

/**
 * ResultCodeEnum:
 *
 * @Author XvYanpeng
 * @Date 2020/3/16 15:49
 */
@Getter
public enum ResultEnum {
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
