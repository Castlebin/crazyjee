package ch08.se04.service.impl;

import ch08.se04.service.Hello;
import org.springframework.stereotype.Component;

@Component
public class HelloImpl implements Hello {

    @Override
    public void foo() {
        System.out.println("执行Hello组件里的foo方法...");
    }

    @Override
    public int addUser(String name, String pass) {
        System.out.println("执行Hello组件里的addUser方法添加用户：" + name);
        if (name.length() < 3 || name.length() > 10) {
            throw new IllegalArgumentException("name字段长度必须大于等于3小于10！");
        }

        return 20;
    }

}
