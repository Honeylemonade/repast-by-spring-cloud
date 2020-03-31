package com.example.productserver.service.impl;


import com.example.productcommon.DecreaseStockInput;
import com.example.productserver.entity.ProductInfo;
import com.example.productserver.enums.ProductStatusEnum;
import com.example.productserver.repository.ProductInfoRepository;
import com.example.productserver.service.ProductService;
import com.example.productserver.utils.JsonUtil;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.JsonObject;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ProductServiceImpl:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 14:54
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private AmqpTemplate amqpTemplate;


    @Override
    public List<ProductInfo> findAllOnSell() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findByProductIdIn(List<Integer> productListId) {

        return productInfoRepository.findByProductIdIn(productListId);
    }

    //事务操作
    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
            ProductInfo productInfo = productInfoOptional.get();
            //库存足够才允许购买(减库存)
            if (productInfo.getProductStock() >= decreaseStockInput.getProductQuantity()) {
                productInfo.setProductStock(productInfo.getProductStock() - decreaseStockInput.getProductQuantity());
                productInfoRepository.save(productInfo);
                //发送mq消息
                amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfo));
            }
        }
    }

}
