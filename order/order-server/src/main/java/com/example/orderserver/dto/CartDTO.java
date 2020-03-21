package com.example.orderserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CartDTO: 购物车中的商品类
 *
 * @Author XvYanpeng
 * @Date 2020/3/18 13:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Integer productId;
    private Integer productQuantity;
}
