package com.ydh.redsheep.dubboprovider.extension;

import com.ydh.redsheep.dubboprovider.spi.AdaptiveTest;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdaptiveExtensionTest {

    @Test
    public void test() {
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
