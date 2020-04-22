package com.ydh.redsheep.simpledemo.simple_demo;

/**
*
* @author : yangdehong
* @date : 2020-04-06 11:54
*/
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
