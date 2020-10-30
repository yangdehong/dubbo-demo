package com.ydh.redsheep.dubboprovider.extension;

import com.ydh.redsheep.dubboprovider.spi.ExtensionDemo;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ExtensionTest {

    @Test
    public void test() {
        URL url = URL.valueOf("test://localhost/test");
        // 普通扩展类
        ExtensionDemo commonExtension = ExtensionLoader.getExtensionLoader(ExtensionDemo.class).getExtension("thrift");
        System.out.println("0="+commonExtension.echo("d", url));
        // 自适应扩展类
        ExtensionDemo adaptiveExtension = ExtensionLoader.getExtensionLoader(ExtensionDemo.class).getAdaptiveExtension();
        System.out.println("1="+adaptiveExtension.echo("d", url));
        URL url2 = URL.valueOf("test://localhost/test?server=cloud");
        System.out.println("2="+adaptiveExtension.echo("d", url2));
        URL url3 = URL.valueOf("test://localhost/test?transporter=cloud");
        System.out.println("3="+adaptiveExtension.echo("d", url3));
        // 自动激活扩展类
        String[] values = {"dubbo", "cloud", "thrift"};
        List<ExtensionDemo> activateExtension = ExtensionLoader.getExtensionLoader(ExtensionDemo.class).getActivateExtension(url, values, null);
        activateExtension.forEach(extensionDemo -> {
            System.out.println("4="+ extensionDemo.echo("d", url));
        });
    }

}
