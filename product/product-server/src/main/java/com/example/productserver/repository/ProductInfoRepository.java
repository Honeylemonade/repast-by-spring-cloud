package com.example.productserver.repository;

import com.example.productserver.entity.ProductInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ProductInfoRepository:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 12:43
 */
@Repository
public interface ProductInfoRepository extends CrudRepository<ProductInfo, Integer> {
    /**
     * 根据产品的上架状态查询产品
     *
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 根据id列表查询对应id的商品信息
     *
     * @param productIdList
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<Integer> productIdList);
}
