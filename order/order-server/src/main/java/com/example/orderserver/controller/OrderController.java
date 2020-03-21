package com.example.orderserver.controller;



import com.example.orderserver.converter.OrderForm2OrderDTOConverter;
import com.example.orderserver.dto.OrderDTO;
import com.example.orderserver.enums.ResultEnum;
import com.example.orderserver.form.OrderForm;
import com.example.orderserver.service.OrderService;
import com.example.orderserver.vo.ResultVO;
import com.example.productclient.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * OrderController:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 18:06
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductClient productClient;

    /**
     * 创建订单
     *
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String, Integer>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        //1，校验参数
        if (bindingResult.hasErrors()) {
            log.error("订单出错");
        } else {
            OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
            OrderDTO result = orderService.create(orderDTO);
            Map<String, Integer> map = new HashMap<>();
            map.put("orderId", result.getOrderId());
            return new ResultVO<Map<String, Integer>>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), map);
        }

        return null;
    }

}
