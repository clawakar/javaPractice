package com.chetan.javaPractice.methodOverLoadingVsOverriding;

public class MethodOverloading1 {
    void fun(int x, long y) {
        System.out.println("fun(int x, long y)");

    }

    void fun (long x, int y){
        System.out.println("fun (long x, int y)");

    }


    void fun (int x, int y){
        System.out.println("fun (int x, int y)");

    }

    void fun (long x, long y){
        System.out.println("fun (long x, long y)");

    }

    public static void main(String[] args) {
        MethodOverloading1 obj = new MethodOverloading1();
        obj.fun(1,2);

    }
}
