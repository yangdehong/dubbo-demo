package com.ydh.redsheep.dubboprovider.service;

import com.ydh.redsheep.dubboapi.service.TPMonitorService;
import com.ydh.redsheep.selffilter.spi.TPMonitorFilter;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;

@Service(version = "1.0.0")
public class TPMonitorServiceImpl implements TPMonitorService {

    static {
        System.out.println("========TP90 TP99 ");
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    ConcurrentMap<String, List<Long>> map = TPMonitorFilter.map;
                    map.keySet().forEach(key -> {
                        if (CollectionUtils.isEmpty(map.get(key))) {
                            return;
                        }
                        List<Long> list = new ArrayList<>();
                        list.addAll(map.get(key));
                        int size = list.size();
                        System.out.println(key+"=====>>>>"+size);
                        // TP90：满足百分之九十的网络请求所需的最低耗时
                        // TP99：满足百分之九十九的网络请求所需的最低耗时
                        boolean flag99 = true;
                        boolean flag90 = true;
                        for (int i = size-1; i >= 0; i--) {
                            if (flag99 && (i+1)/size<0.99) {
                                System.out.println(key+"的TP99="+list.get(i));
                                flag99 = false;
                            }
                            if (flag90 && (i+1)/size<0.90) {
                                System.out.println(key+"的TP90="+list.get(i));
                                flag90 = false;
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void methodA() {
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void methodB() {
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void methodC() {
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
