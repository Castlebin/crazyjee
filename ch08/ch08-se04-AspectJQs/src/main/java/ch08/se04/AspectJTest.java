package ch08.se04;

import ch08.se04.service.Hello;
import ch08.se04.service.World;

public class AspectJTest {

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.foo();
        hello.addUser("孙悟空", "778899");

        World world = new World();
        world.bar();
    }

}
