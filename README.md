# repast项目简介

使用Spring cloud实现点餐业务的微服务架构。

# 项目服务

## Product服务

### 简介

该服务用于维护系统的商品，包括商品的基本信息，库存量，状态等。

### 数据库

**类目表：**product_category（id,类别名称,类别种类）

**商品表：**Product_info（id,名称,价格,描述,描述,图片地址,商品库存,商品状态[0表示正常，1表示下架],商品的类别[对应上表类别id]）

### UML类图



### 对外接口

> 详情请查看Postman生成的接口文档https://documenter.getpostman.com/view/7413665/SzS7R6zT?version=latest#d5e414d0-c66b-4d1e-8071-0f77d3b49271

1. POST 减库存http://localhost:8083/product/decreaseStock
2. GET 查询在架商品列表：http://localhost:8083/product/list
3. POST 根据商品ID列表，获取对应商品信息（提供给Order服务调用）：http://localhost:8083/product/listForOrder

## Order服务

### 简介

该服务用于维护系统的订单，包括订单的基本信息，订单的支付状态等

### 数据库

> 设置了部分冗余数据

**订单表：**order_master（id,买家名称,买家电话,买家Id,订单总金额,订单状态,支付状态）

**订单中的详情.表：**order_detail（detail_id,所属订单id,商品id,商品名称,商品单价,数量,小图）

### 对外接口

> 详情请查看Postman生成的接口文档https://documenter.getpostman.com/view/7413665/SzS7R6zT?version=latest#d5e414d0-c66b-4d1e-8071-0f77d3b49271

1. POST 创建订单http://localhost:8084/order/create

