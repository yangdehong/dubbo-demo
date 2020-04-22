package com.ydh.redsheep.dubboprovider.service;

import com.ydh.redsheep.dubboapi.service.DemoService;
import org.apache.dubbo.config.annotation.Service;

/**
*
* @author : yangdehong
* @date : 2020-04-06 11:54
*/
@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
