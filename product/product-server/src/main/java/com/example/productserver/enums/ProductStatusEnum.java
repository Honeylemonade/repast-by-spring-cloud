package com.example.productserver.enums;

import lombok.Getter;

/**
 * ProductStatusEnum:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 14:57
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架"),
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
