package com.ydh.redsheep.selffilter.spi;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Activate(group = {CommonConstants.PROVIDER})
public class TPMonitorFilter implements Filter {
    /**
     * TODO 不用dubbo的线程池，不然还得加全局变量，有点麻烦
     */
    public static ConcurrentMap<String, List<Long>> map = new ConcurrentHashMap<>();

    /**
     * Make sure call invoker.invoke() in your implementation.
     *
     * @param invoker
     * @param invocation
     */
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        long startTime = System.currentTimeMillis();
        try {
            // 执行方法
            return invoker.invoke(invocation);
        } finally {
            String methodName = invocation.getMethodName();
            long time = (System.currentTimeMillis()-startTime);
            List<Long> list = map.get(methodName);
            if (CollectionUtils.isEmpty(list)) {
                list = new ArrayList<>();
                list.add(time);
                map.put(methodName, list);
            } else {
                list.add(time);
            }
            Collections.sort(list);
        }
    }
}
