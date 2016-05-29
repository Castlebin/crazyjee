package ch08.se04.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ReleaseAspect {

    @After("execution(* ch08.se04.service.impl.*.*(..))")
    public void release() {
        System.out.println("模拟进行方法结束后的资源释放...");
    }

}
