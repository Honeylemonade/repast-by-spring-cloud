package com.example.orderserver.message;

import com.example.orderserver.utils.JsonUtil;
import com.example.productcommon.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * ProductInfo:
 *
 * @Author XvYanpeng
 * @Date 2020/3/31 14:35
 */
@Component
@Slf4j
public class ProductInfoReceiver {
    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 监听productInfo队列，接收并处理消息
     *
     * @param message
     */
    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        ProductInfoOutput productInfoOutput = (ProductInfoOutput) JsonUtil.fromJson(message, ProductInfoOutput.class);
        log.info("从队列productInfo接收到消息:" + productInfoOutput.toString());
        //存储到redis中
        stringRedisTemplate.opsForValue()
                .set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getCategoryId()),
                        String.valueOf(productInfoOutput.getProductStock()));
    }
}
