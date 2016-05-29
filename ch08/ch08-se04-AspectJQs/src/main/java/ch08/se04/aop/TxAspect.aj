package ch08.se04.aop;

public aspect TxAspect {

    Object around() : call(* ch08.se04.service.*.*(..)) {
        System.out.println("模拟开启事务...");

        // 回调原来的目标方法
        Object rvt = proceed();

        System.out.println("模拟结束事务...");

        return rvt;
    }

}
