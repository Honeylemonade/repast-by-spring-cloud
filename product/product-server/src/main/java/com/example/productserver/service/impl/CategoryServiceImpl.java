package com.example.productserver.service.impl;


import com.example.productserver.entity.ProductCategory;
import com.example.productserver.repository.ProductCategoryRepository;
import com.example.productserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CategoryServiceImpl:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 16:08
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryIdIn(List<Integer> categoryIdList) {
        return productCategoryRepository.findByCategoryIdIn(categoryIdList);
    }
}
