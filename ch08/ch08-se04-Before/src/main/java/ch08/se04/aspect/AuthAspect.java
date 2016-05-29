package ch08.se04.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AuthAspect {

    @Before("execution(* ch08.se04.service.impl.*.*(..))")
    public void authority() {
        System.out.println("模拟进行权限检查...");
    }

}
