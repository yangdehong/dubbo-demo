package com.ydh.redsheep.selffilter.spi;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcException;

/**
* 自定义filter-使用spi做一个filter
* @author : yangdehong
* @date : 2021/1/3 11:03
*/
@Activate(group = {CommonConstants.CONSUMER,CommonConstants.PROVIDER})
public class MyFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, org.apache.dubbo.rpc.Invocation invocation) throws RpcException {
        long   startTime  = System.currentTimeMillis();
        try {
            // 执行方法
            return  invoker.invoke(invocation);
        } finally {
            System.out.println("invoke time:"+(System.currentTimeMillis()-startTime) + "毫秒");
        }
    }
}
