package com.ydh.redsheep.simpledemo.simple_demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
*
* @author : yangdehong
* @date : 2020-04-06 11:57
*/
public class CustomerMain {

    public static void main(String[] args) throws Exception {
        System.out.println("=========start="+System.currentTimeMillis());
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"simple_demo/consumer.xml"});
        context.start();
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        System.out.println("=========begin="+System.currentTimeMillis());
        String hello = demoService.sayHello("world"); // 执行远程方法
        System.out.println("=========end="+System.currentTimeMillis());
        System.out.println( hello ); // 显示调用结果

        Thread.sleep(10000);
    }
}
