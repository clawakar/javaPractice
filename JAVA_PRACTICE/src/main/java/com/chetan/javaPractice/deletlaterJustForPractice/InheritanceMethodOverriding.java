package com.chetan.javaPractice.deletlaterJustForPractice;

class A {
    A get () {
        return this;
    }
    void f1() {
        System.out.println("A:f1()");
        this.f2();
        f2();
    }
    void f2() {
        System.out.println("A:f2()");

    }

}

class  B extends A {

    B get () {
        return this;
    }
    void f2() {
        System.out.println("B:f2()");
    }

    void f3() {
        System.out.println("B:f3()");

    }
}

public class InheritanceMethodOverriding {
    public static void main(String[] args) {
        A b = new B();
        b.f1();
        //b.f3();   // can not resolve the method


    }
}
