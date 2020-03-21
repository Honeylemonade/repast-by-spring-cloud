package com.example.productserver.service;



import com.example.productcommon.DecreaseStockInput;
import com.example.productserver.entity.ProductInfo;

import java.util.List;

/**
 * ProductService:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 14:54
 */
public interface ProductService {
    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findAllOnSell();

    /**
     * 根据id列表返回对应商品信息
     *
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<Integer> productListId);

    /**
     * 扣除库存
     *
     * @param cartDTOList
     */
    void decreaseStock(List<DecreaseStockInput> cartDTOList);
}
