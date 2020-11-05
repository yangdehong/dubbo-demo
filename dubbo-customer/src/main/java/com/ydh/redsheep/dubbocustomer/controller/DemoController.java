package com.ydh.redsheep.dubbocustomer.controller;

import com.ydh.redsheep.dubboapi.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
*
* @author : yangdehong
* @date : 2020-04-20 14:55
*/
@Slf4j
@RestController
public class DemoController {

    @Reference(version = "1.0.0")
    private DemoService demoService;

    @RequestMapping("/demo")
    public String getCost(){
        log.info("调用时间={}", LocalDateTime.now());
        return "返回结果 ："+demoService.sayHello("中国");
    }

}
