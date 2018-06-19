package com.chetan.javaPractice.methodOverLoadingVsOverriding;

import java.util.List;
import java.util.ArrayList;

public class inheritanceAccessModifier {
    public static void main(String[] args)
    {
        A1 a = new A2();
        a.x = 13; // we can access protected members even inheritanceAccessModifier is not sub class of A

        a.display2(5); //we can access protected members even inheritanceAccessModifier is not sub class of A
    }
}

class A1
{
    protected static int x ;
    static void display()
    {
        System.out.println("A1.x : " + x);
    }

    public void display2(int x)
    {
        System.out.println("A1.x : " + x);
    }

    public A1 fun1() {
        return this;

    }
}

class A2 extends A1
{
    //protected int x ;
    static void display()
    {
        System.out.println("A2.x : " + x);
    }

    public void display2(int x)
    {
        System.out.println("A2.x : " + x);
    }

    public static void display2(int x, int y)
    {
        System.out.println("A2.x : " + x);

    }
    @Override
    public A2 fun1(){
        return this;
    }
}
