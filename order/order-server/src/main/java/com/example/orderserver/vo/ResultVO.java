package com.example.orderserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ResultVO:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 18:26
 */
@Data
@AllArgsConstructor
public class ResultVO<T> {
    private Integer code;

    private String msg;

    private T data;
}
