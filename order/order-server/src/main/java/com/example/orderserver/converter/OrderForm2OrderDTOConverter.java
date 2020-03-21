package com.example.orderserver.converter;


import com.example.orderserver.dto.OrderDTO;
import com.example.orderserver.entity.OrderDetail;
import com.example.orderserver.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * OrderForm2OrderDTOConverter:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 20:11
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerId(orderForm.getBuyerId());
        Gson gson = new Gson();
        List<OrderDetail> orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
        }.getType());
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}