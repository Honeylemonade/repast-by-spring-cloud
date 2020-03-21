package com.example.productserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * product_category:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 13:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer categoryId;

    /**
     * 类目名字.
     */
    private String categoryName;
}
