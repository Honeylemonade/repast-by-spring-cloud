package com.example.orderserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients(basePackages = "com.example.productclient")
@SpringBootApplication

public class OrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class, args);
    }

}
