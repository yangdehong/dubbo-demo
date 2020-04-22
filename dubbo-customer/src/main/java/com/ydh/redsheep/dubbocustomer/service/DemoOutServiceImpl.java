package com.ydh.redsheep.dubbocustomer.service;

import com.ydh.redsheep.dubboapi.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
*
* @author : yangdehong
* @date : 2020-04-06 11:54
*/
@Service
public class DemoOutServiceImpl implements DemoOutService {

    @Reference(version = "1.0.0")
    private DemoService demoService;

    @Override
    public String sayHello(String name) {
        return demoService.sayHello(name);
    }
}
