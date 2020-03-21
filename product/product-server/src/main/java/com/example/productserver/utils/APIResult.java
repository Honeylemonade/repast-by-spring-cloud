package com.example.productserver.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ResultVO:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 17:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResult<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
