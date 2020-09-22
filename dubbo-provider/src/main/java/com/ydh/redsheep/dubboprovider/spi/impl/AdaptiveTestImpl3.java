package com.ydh.redsheep.dubboprovider.spi.impl;

import com.ydh.redsheep.dubboprovider.spi.AdaptiveTest;
import org.apache.dubbo.common.URL;

//@Adaptive // 在类上注释了，不管是url还是默认都不会再使用了，只使用这个注释
public class AdaptiveTestImpl3 implements AdaptiveTest {

    @Override
    public String echo(String msg, URL url) {
        return "33333";
    }

}
