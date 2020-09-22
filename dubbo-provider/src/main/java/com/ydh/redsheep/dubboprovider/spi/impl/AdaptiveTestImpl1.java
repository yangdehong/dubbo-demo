package com.ydh.redsheep.dubboprovider.spi.impl;

import com.ydh.redsheep.dubboprovider.spi.AdaptiveTest;
import org.apache.dubbo.common.URL;

public class AdaptiveTestImpl1 implements AdaptiveTest {

    @Override
    public String echo(String msg, URL url) {
        return "111111";
    }

}
