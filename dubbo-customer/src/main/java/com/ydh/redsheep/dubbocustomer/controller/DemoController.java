package com.ydh.redsheep.dubbocustomer.controller;

import com.ydh.redsheep.dubboapi.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author : yangdehong
* @date : 2020-04-20 14:55
*/
@RestController
public class DemoController {

    @Reference(version = "1.0.0")
    private DemoService demoService;

    @RequestMapping("/demo")
    public String getCost(){
        return "返回结果 ："+demoService.sayHello("中国");
    }

}
