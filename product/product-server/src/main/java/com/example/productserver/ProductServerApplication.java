package com.example.productserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProductServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServerApplication.class, args);

    }

}
