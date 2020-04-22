package com.ydh.redsheep.simpledemo.simple_demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
*
* @author : yangdehong
* @date : 2020-04-06 11:57
*/
public class ProviderMain {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"simple_demo/provider.xml"});
        context.start();
        // 按任意键退出
        System.in.read();
    }

}
