package com.chetan.javaPractice.staticBindingAndDynamicBinding;

public class StaticBindingDemo1 {
    public static void main(String[] args) {

        A Aobj = new B();
        //Aobj.fun6(); // fun6() have private access in class A

    }
}

class A {

    private void fun1() {System.out.println("A : fun1()");}

    final void fun2() {System.out.println("A : fun2()");}

    static void fun3() {System.out.println("A : fun3()");}

    static final void fun4() {System.out.println("A : fun4()");}

    private static void fun5() {System.out.println("A : fun5()");}

    private final void fun6() {System.out.println("A : fun6()");}

    private static final void fun7() { System.out.println("A : fun7()");}
}

class B extends A {
    private void fun1() {System.out.println("B : fun1()");}

    //final void fun2() {System.out.println("B : fun2()");} // error : overridden method is final
    //void fun2() {System.out.println("B : fun2()");} // error : overridden method is final
    void fun2(int x) {System.out.println("B : fun2(int x)");} // allowed , no error.
    // here A.fun2(int x) signature is not same as B.fun() hence this is not treated as method overriding.

    static void fun3() {System.out.println("B : fun3()");}

    //static final void fun4() {System.out.println("B : fun4()");} // error : overridden method is final
    //static void fun4() {System.out.println("B : fun4()");} // error : overridden method is final

    private static void fun5() {System.out.println("B : fun5()");}

    public final void fun6() {System.out.println("B : fun6()");} // allowed

    private static final void fun7() { System.out.println("B : fun7()");}

}
