package com.ydh.redsheep.dubbocustomer.controller;

import com.ydh.redsheep.dubboapi.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.validation.MethodValidated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;

/**
*
* @author : yangdehong
* @date : 2020-04-20 14:55
*/
@Slf4j
@RestController
public class DemoController {

//    @Reference(version = "1.0.0", check = false, loadbalance = "onlyFirst")
//    @Reference(version = "1.0.0", check = false, loadbalance = "roundrobin", mock = "return 123")
    @Reference(version = "1.0.0", check = false, loadbalance = "roundrobin")
    private DemoService demoService;

    @RequestMapping("/demo")
    public String getCost(){
        log.info("调用时间={}", LocalDateTime.now());
        // 线程池使用
//        for (int i=0; i<10000; i++) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            new Thread(() -> {
//                String msg = demoService.sayHello("中国" + new Random().nextInt());
//                System.out.println(msg);
//            }).start();
//        }
        return "返回结果 ："+demoService.sayHello("中国");
    }

}
