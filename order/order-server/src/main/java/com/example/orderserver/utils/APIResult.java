package com.example.orderserver.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * APIResult:
 *
 * @Author XvYanpeng
 * @Date 2020/3/16 16:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResult<T> {
    private Integer code;

    private String msg;

    private T data;
}
