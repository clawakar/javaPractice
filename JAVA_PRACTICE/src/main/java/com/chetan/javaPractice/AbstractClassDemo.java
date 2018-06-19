package com.chetan.javaPractice;

public class AbstractClassDemo {

    public static void main(String[] args ) {
        //A obj = new A();
        //B obj = new B();
        C obj = new C();
        obj.dance();
        obj.call();
        obj.move();



    }
}

abstract class A {
    public void call() {
        System.out.println("A: calling");
    }

    abstract public void move();
    abstract public void dance();
}


abstract class B extends A {
    public void move() {
        System.out.println("B: moving");
    }
}

class C extends B{
    public void dance() {
        System.out.println("C: Danceing");
    }
}
