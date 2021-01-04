package com.ydh.redsheep.self_router.router;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ZookeeperClients {
    private final CuratorFramework client;
    private static ZookeeperClients INSTANCE;

    static {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("172.16.131.6:2181", retryPolicy);
        INSTANCE = new ZookeeperClients(client);
        client.start();
    }

    private ZookeeperClients(CuratorFramework client) {
        this.client = client;
    }

    public static CuratorFramework client() {
        return INSTANCE.client;
    }
}
