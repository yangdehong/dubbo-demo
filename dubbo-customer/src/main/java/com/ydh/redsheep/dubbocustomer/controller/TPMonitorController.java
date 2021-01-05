package com.ydh.redsheep.dubbocustomer.controller;

import com.ydh.redsheep.dubboapi.service.TPMonitorService;
import com.ydh.redsheep.selffilter.spi.TPMonitorFilter;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
public class TPMonitorController {

    @Reference(version = "1.0.0", check = false)
    private TPMonitorService tpMonitorService;

    @RequestMapping("/tpMonitor")
    public String getCost(){
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(() -> {
                tpMonitorService.methodA();
            });
            executorService.execute(() -> {
                tpMonitorService.methodB();
            });executorService.execute(() -> {
                tpMonitorService.methodC();
            });
        }
//        return "success";
    }

}
