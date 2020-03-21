package com.example.productcommon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * ProductInfoOutput:
 *
 * @Author XvYanpeng
 * @Date 2020/3/20 14:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoOutput {

    private Integer productId;

    /**
     * 名字.
     */
    private String productName;

    /**
     * 单价.
     */
    private BigDecimal productPrice;

    /**
     * 库存.
     */
    private Integer productStock;

    /**
     * 描述.
     */
    private String productDescription;

    /**
     * 小图.
     */
    private String productPic;

    /**
     * 状态, 0正常1下架.
     */
    private Integer productStatus;

    /**
     * 类目编号.
     */
    private Integer categoryId;
}
