package ch08.se04.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAspect {

    @AfterReturning(returning = "rvt",
        pointcut = "execution(* ch08.se04.service.impl.*.*(..))")
    public void log(Object rvt) {
        System.out.println("获取目标方法的返回值：" + rvt);
        System.out.println("模拟记录日志功能...");
    }

}
