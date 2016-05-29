package ch08.se04.aspect;

public aspect AuthAspect {

    before() : execution(* ch08.se04.service.*.*(..)) {
        System.out.println("模拟进行权限检查...");
    }

}
