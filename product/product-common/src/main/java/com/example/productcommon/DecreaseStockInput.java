package com.example.productcommon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DecreaseStockInput:
 *
 * @Author XvYanpeng
 * @Date 2020/3/20 14:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecreaseStockInput {
    private Integer productId;
    private Integer productQuantity;
}
