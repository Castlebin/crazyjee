package ch08.se04.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TxAspect {

    // Around增强处理方法的第一个参数必须为ProceedingJoinPoint类型，并且必须有
    @Around("execution(* ch08.se04.service.impl.*.*(..))")
    public Object processTx(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("执行目标方法之前，模拟开启事务...");

        // 获取目标方法的原始调用参数
        Object[] args = jp.getArgs();
        if (args != null && args.length > 1) {
            // 改变原始的调用参数值
            args[0] = "[增强的前缀]" + args[0];
        }
        // 以改变后的参数去执行目标方法，并获取返回值
        Object rvt = jp.proceed(args);
        System.out.println("方法执行之后，模拟结束事务...");

        // 改变返回值
        if (rvt != null && rvt instanceof Integer) {
            rvt = (Integer)rvt * (Integer)rvt;
        }

        return rvt;
    }

}
