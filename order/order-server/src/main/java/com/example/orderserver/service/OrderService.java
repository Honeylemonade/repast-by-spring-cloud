package com.example.orderserver.service;


import com.example.orderserver.dto.OrderDTO;

/**
 * OrderService:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 18:07
 */
public interface OrderService {
    /**
     * 创建订单 orderDTO为master和detail的合集
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单(只能卖家操作)
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
