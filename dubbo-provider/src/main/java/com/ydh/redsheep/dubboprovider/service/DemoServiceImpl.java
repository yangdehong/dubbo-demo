package com.ydh.redsheep.dubboprovider.service;

import com.ydh.redsheep.dubboapi.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import java.time.LocalDateTime;

/**
*
* @author : yangdehong
* @date : 2020-04-06 11:54
*/
@Slf4j
@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        log.info("时间={}", LocalDateTime.now());
        try {
            Thread.sleep(60*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("时间={}", LocalDateTime.now());
        return "Hello " + name;
    }
}
