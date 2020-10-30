package com.ydh.redsheep.dubboprovider.spi.impl;

import com.ydh.redsheep.dubboprovider.spi.ExtensionDemo;
import org.apache.dubbo.common.URL;

//@Adaptive // 在类上注释了，不管是url还是默认都不会再使用了，只使用这个注释
public class ExtensionDemoImpl3 implements ExtensionDemo {

    @Override
    public String echo(String msg, URL url) {
        return "33333";
    }

}
