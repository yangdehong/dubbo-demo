package com.ydh.redsheep.dubboprovider.service;

import com.ydh.redsheep.dubboapi.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
*
* @author : yangdehong
* @date : 2020-04-06 11:54
*/
@Slf4j
@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

    @Value("${server.port}")
    private String port;

    @Override
    public String sayHello(String name) {
        try {
            Thread.sleep(60*1000);
//            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello " + port + name;
    }
}
