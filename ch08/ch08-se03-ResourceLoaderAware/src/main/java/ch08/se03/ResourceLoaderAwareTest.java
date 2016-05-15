package ch08.se03;

import org.dom4j.DocumentException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

import ch08.se03.bean.TestBean;

public class ResourceLoaderAwareTest {
    public static void main(String[] args) throws IOException, DocumentException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        TestBean tb = ctx.getBean("tb", TestBean.class);
        ResourceLoader resourceLoader = tb.getResourceLoader();
        // 判断程序获得的ResourceLoader是否就是Spring容器本身
        System.out.println(ctx == resourceLoader);
    }
}
