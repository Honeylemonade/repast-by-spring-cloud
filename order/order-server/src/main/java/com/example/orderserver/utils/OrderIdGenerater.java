package com.example.orderserver.utils;

/**
 * OrderIdGenerater:生成唯一主键随机数
 *
 * @Author XvYanpeng
 * @Date 2020/3/17 15:41
 */
public class OrderIdGenerater {
    public static synchronized int getUniqueKey() {
        return (int) (System.currentTimeMillis() / 1000);
    }
}
