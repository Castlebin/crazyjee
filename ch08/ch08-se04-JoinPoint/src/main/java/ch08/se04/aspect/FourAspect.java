package ch08.se04.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class FourAspect {

    // Around增强处理方法的第一个参数必须为ProceedingJoinPoint类型，并且必须有
    @Around("execution(* ch08.se04.service.impl.*.*(..))")
    public Object processTx(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("Around增强:执行目标方法之前，模拟开启事务...");

        // 获取目标方法的原始调用参数
        Object[] args = jp.getArgs();
        if (args != null && args.length > 1) {
            // 改变原始的调用参数值
            args[0] = "[增强的前缀]" + args[0];
        }
        // 以改变后的参数去执行目标方法，并获取返回值
        Object rvt = jp.proceed(args);
        System.out.println("Around增强:方法执行之后，模拟结束事务...");

        // 改变返回值
        if (rvt != null && rvt instanceof Integer) {
            rvt = (Integer) rvt * (Integer) rvt;
        }

        return rvt;
    }

    @Before("execution(* ch08.se04.service.impl.*.*(..))")
    public void authority(JoinPoint jp) {
        System.out.println("Before增强：模拟执行权限检查...");
        // 获取织入增强处理的目标方法
        System.out.println("Before增强：被织入增强处理的目标方法为：" + jp.getSignature().getName());
        // 访问目标方法的参数
        System.out.println("Before增强：目标方法的参数为：" + Arrays.toString(jp.getArgs()));
        // 访问被增强处理的对象
        System.out.println("Before增强：被织入的目标对象为：" + jp.getTarget());
    }

    @AfterReturning(value = "execution(* ch08.se04.service.impl.*.*(..))", returning = "rvt")
    public void log(JoinPoint jp, Object rvt) {
        System.out.println("AfterReturning增强：获取目标方法返回值:" + rvt);
        System.out.println("AfterReturning增强：模拟记录日志功能...");
        // 返回被织入增强处理的目标方法
        System.out.println("AfterReturning增强：被织入增强处理的目标方法为：" + jp.getSignature().getName());
        // 访问执行目标方法的参数
        System.out.println("AfterReturning增强：目标方法的参数为：" + Arrays.toString(jp.getArgs()));
        // 访问被增强处理的目标对象
        System.out.println("AfterReturning增强：被织入增强处理的目标对象为：" + jp.getTarget());
    }

    // 定义After增强处理
    @After("execution(* ch08.se04.service.impl.*.*(..))")
    public void release(JoinPoint jp) {
        System.out.println("After增强：模拟方法结束后的释放资源...");
        // 返回被织入增强处理的目标方法
        System.out.println("After增强：被织入增强处理的目标方法为：" + jp.getSignature().getName());
        // 访问执行目标方法的参数
        System.out.println("After增强：目标方法的参数为：" + Arrays.toString(jp.getArgs()));
        // 访问被增强处理的目标对象
        System.out.println("After增强：被织入增强处理的目标对象为：" + jp.getTarget());
    }

}
