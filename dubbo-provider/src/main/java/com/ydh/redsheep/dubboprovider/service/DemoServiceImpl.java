package com.ydh.redsheep.dubboprovider.service;

import com.ydh.redsheep.dubboapi.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;

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
        try {
//            Thread.sleep(60*1000);
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello 222" + name;
    }
}
