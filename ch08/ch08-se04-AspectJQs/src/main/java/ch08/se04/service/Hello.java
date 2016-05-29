package ch08.se04.service;

public class Hello {

    public void foo() {
        System.out.println("执行Hello组件的foo方法");
    }

    // 定义一个addUser()方法，模拟应用中添加用户的方法
    public int addUser(String name, String pass) {
        System.out.println("执行Hello组件的addUser方法添加用户：" + name);

        return 20;
    }

}
