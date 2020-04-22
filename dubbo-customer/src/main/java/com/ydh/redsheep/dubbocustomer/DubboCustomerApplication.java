package com.ydh.redsheep.dubbocustomer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
*
* @author : yangdehong
* @date : 2020-04-20 14:26
*/
@EnableDubbo
@SpringBootApplication
public class DubboCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboCustomerApplication.class, args);
    }

}
