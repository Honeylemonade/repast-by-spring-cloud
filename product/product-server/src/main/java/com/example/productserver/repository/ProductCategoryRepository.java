package com.example.productserver.repository;


import com.example.productserver.entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ProductCategory:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 16:04
 */
@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
    /**
     * 查询类别编号位于{.....}的商品类别
     *
     * @return
     */
    List<ProductCategory> findByCategoryIdIn(List<Integer> categoryIdList);
}
