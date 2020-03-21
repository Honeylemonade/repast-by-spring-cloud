package com.example.orderserver.exception;


import com.example.orderserver.enums.ResultEnum;

/**
 * OrderException:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 20:07
 */
public class OrderException extends RuntimeException{
    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
