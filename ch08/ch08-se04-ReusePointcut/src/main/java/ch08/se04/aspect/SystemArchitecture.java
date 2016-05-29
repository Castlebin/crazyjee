package ch08.se04.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {

    @Pointcut("execution(* ch08.se04.service.impl.*.*(..))")
    public void servicePointcut() {}

}
