package com.ydh.redsheep.dubboprovider.spi.impl;

import com.ydh.redsheep.dubboprovider.spi.ExtensionDemo;
import org.apache.dubbo.common.URL;

public class ExtensionDemoImpl1 implements ExtensionDemo {

    @Override
    public String echo(String msg, URL url) {
        return "111111";
    }

}
