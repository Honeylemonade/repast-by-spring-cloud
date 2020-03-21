package com.example.orderserver.repository;


import com.example.orderserver.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * OrderMasterRepository:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 17:47
 */
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, Integer> {
}
