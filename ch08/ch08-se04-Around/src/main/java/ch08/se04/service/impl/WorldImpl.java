package ch08.se04.service.impl;

import ch08.se04.service.World;
import org.springframework.stereotype.Component;

@Component
public class WorldImpl implements World {

    @Override
    public void bar() {
        System.out.println("执行World组件的bar方法...");
    }

}
