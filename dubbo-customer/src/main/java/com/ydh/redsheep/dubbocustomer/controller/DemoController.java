package com.ydh.redsheep.dubbocustomer.controller;

import com.ydh.redsheep.dubbocustomer.service.DemoOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author : yangdehong
* @date : 2020-04-20 14:55
*/
@RestController
public class DemoController {

    @Autowired
    private DemoOutService demoOutService;

    @RequestMapping("/demo")
    public String getCost(){
        return "返回结果 ："+demoOutService.sayHello("中国");
    }

}
