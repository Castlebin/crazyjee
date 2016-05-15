package ch07.se09.bean;

public abstract class Chinese implements Person {

    private Dog dog;

    public abstract Dog getDog();

    @Override
    public void hunt() {
        System.out.println("带着Dog：" + getDog() + " 去打猎");
    }

}
