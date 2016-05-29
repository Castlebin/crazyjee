package ch08.se04.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class RepairAspect {

    // AfterThrowing增强会对切入点的异常进行处理，但是处理完后仍然会将这个异常抛出到上层调用者
    // 所以程序仍然会由于异常的存在而终止，假如上层调用者并未对异常进行处理的话
    @AfterThrowing(throwing = "throwable",
            pointcut = "execution(* ch08.se04.service.impl.*.*(..))")
    public void doRecovery(Throwable throwable) {
        System.out.println("目标方法中抛出的异常：" + throwable);
        System.out.println("模拟Advice对异常的修复...");
    }

}
