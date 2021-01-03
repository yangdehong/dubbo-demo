package com.ydh.redsheep.selfthreadpoll.threadpool;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.threadpool.support.fixed.FixedThreadPool;

import java.util.Map;
import java.util.concurrent.*;

public class WachingThreadPool extends FixedThreadPool implements Runnable {
    // 定义线程池使用的阀值
    private static final double ALARM_PERCENT = 90;
    private final Map<URL, ThreadPoolExecutor> THREAD_POOLS = new ConcurrentHashMap<>();

    public WachingThreadPool() {
        // 每隔3秒打印线程使用情况
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(this, 1, 3, TimeUnit.SECONDS);
    }

    // 通过父类创建线程池
    @Override
    public Executor getExecutor(URL url) {
        final Executor executor = super.getExecutor(url);
        if (executor instanceof ThreadPoolExecutor) {
            THREAD_POOLS.put(url, (ThreadPoolExecutor) executor);
        }
        return executor;
    }

    @Override
    public void run() {
        // 遍历线程池
        for (Map.Entry<URL, ThreadPoolExecutor> entry : THREAD_POOLS.entrySet()) {
            final URL url = entry.getKey();
            final ThreadPoolExecutor executor = entry.getValue();
            // 计算相关指标
            final int activeCount = executor.getActiveCount();
            final int poolSize = executor.getCorePoolSize();
            double usedPercent = activeCount / (poolSize * 1.0) * 100;
            System.out.println("线程池执行状态:[" + activeCount + "/" + poolSize + ":" + usedPercent + "%]");
            if (usedPercent > ALARM_PERCENT) {
                System.out.println("超出警戒线! host:" + url.getIp() + " 当前使用率是:"+ usedPercent + ",URL:" + url + "");
            }

        }
    }
}
