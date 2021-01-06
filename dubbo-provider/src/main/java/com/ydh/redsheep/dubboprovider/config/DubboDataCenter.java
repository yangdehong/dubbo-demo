package com.ydh.redsheep.dubboprovider.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DubboDataCenter {

    @PostConstruct
    public void init() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("172.16.131.6:2181", retryPolicy);
        client.start();

        if (client.checkExists().forPath("/dubbo/config/dubbo/dubbo.properties") == null) {
            client.create().creatingParentsIfNeeded().forPath("/dubbo/config/dubbo/dubbo.properties");
        }
        client.setData().forPath("/dubbo/config/dubbo/dubbo.properties", ("dubbo.registry.address=zookeeper://172.16.131.6:2181\n" +
                "dubbo.metadata-report.address=zookeeper://172.16.131.6:2181").getBytes());
    }

}
