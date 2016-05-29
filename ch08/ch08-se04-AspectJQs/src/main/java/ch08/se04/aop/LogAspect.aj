package ch08.se04.aop;

public aspect LogAspect {

    pointcut logPointcut() : execution(* ch08.se04.service.*.*(..));

    after() : logPointcut() {
        System.out.println("模拟进行日志记录...");
    }

}
