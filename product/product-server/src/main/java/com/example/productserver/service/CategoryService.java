package com.example.productserver.service;



import com.example.productserver.entity.ProductCategory;

import java.util.List;

/**
 * CategoryService:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 16:08
 */
public interface CategoryService {
    /**
     * 查询类别编号位于{.....}的商品类别
     *
     * @param CategoryIdList
     * @return
     */
    List<ProductCategory> findByCategoryIdIn(List<Integer> CategoryIdList);
}
