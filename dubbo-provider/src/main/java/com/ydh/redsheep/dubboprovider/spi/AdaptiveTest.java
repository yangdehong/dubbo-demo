package com.ydh.redsheep.dubboprovider.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
*
* @author : yangdehong
* @date : 2020-09-22 11:25
*/
@SPI("dubbo")
public interface AdaptiveTest {
    @Adaptive({"server", "transporter"})
    String echo(String msg, URL url);
}
