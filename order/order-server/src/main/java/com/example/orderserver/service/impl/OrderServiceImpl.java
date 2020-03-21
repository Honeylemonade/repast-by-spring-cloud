package com.example.orderserver.service.impl;


import com.example.orderserver.dto.CartDTO;
import com.example.orderserver.dto.OrderDTO;
import com.example.orderserver.entity.OrderDetail;
import com.example.orderserver.entity.OrderMaster;
import com.example.orderserver.entity.ProductInfo;
import com.example.orderserver.enums.OrderStatusEnum;
import com.example.orderserver.enums.PayStatusEnum;
import com.example.orderserver.repository.OrderDetailRepository;
import com.example.orderserver.repository.OrderMasterRepository;
import com.example.orderserver.service.OrderService;
import com.example.orderserver.utils.OrderIdGenerater;
import com.example.productclient.ProductClient;
import com.example.productcommon.DecreaseStockInput;
import com.example.productcommon.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * OrderServiceImpl:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 20:16
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        int id = OrderIdGenerater.getUniqueKey();
        //TODO 查询商品信息（调用商品服务）lamada表达式
        List<Integer> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoOutput> productInfoOutputList = productClient.listForOrder(productIdList);
        List<ProductInfo> productInfoList = new ArrayList<>();
        for (ProductInfoOutput p : productInfoOutputList) {
            ProductInfo temp = new ProductInfo();
            BeanUtils.copyProperties(p, temp);
            productInfoList.add(temp);
        }

        //TODO 计算订单总价
        BigDecimal orderAmount = new BigDecimal(0);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(id);
                    orderDetail.setProductIcon(productInfo.getProductPic());
                    orderDetail.setDetailId(id + new Random().nextInt(1000));
                }
            }
        }
        //TODO 扣除库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());

        List<DecreaseStockInput> decreaseStockInputList = new ArrayList<>();
        for (CartDTO c : cartDTOList) {
            DecreaseStockInput temp = new DecreaseStockInput();
            BeanUtils.copyProperties(c, temp);
            decreaseStockInputList.add(temp);
        }

        productClient.decreaseStock(decreaseStockInputList);
        //master订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(id);
        orderMaster.setBuyerId(orderDTO.getBuyerId());
        orderMaster.setBuyerName(orderDTO.getBuyerName());
        orderMaster.setBuyerPhone(orderDTO.getBuyerPhone());
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        //detail订单详情入库
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            orderDetailRepository.save(orderDetail);
        }
        orderDTO.setOrderId(id);
        return orderDTO;
    }

    @Override
    public OrderDTO finish(String orderId) {
        return null;
    }
}
