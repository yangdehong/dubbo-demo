package com.ydh.redsheep.dubboprovider.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class Main {

    public static void main(String[] args) {
        // adaptive扩展类
        AdaptiveTest adaptiveExtension = ExtensionLoader.getExtensionLoader(AdaptiveTest.class).getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test");
        System.out.println("1="+adaptiveExtension.echo("d", url));
        URL url2 = URL.valueOf("test://localhost/test?server=cloud");
        System.out.println("2="+adaptiveExtension.echo("d", url2));
        URL url3 = URL.valueOf("test://localhost/test?transporter=cloud");
        System.out.println("2="+adaptiveExtension.echo("d", url3));
    }

}
