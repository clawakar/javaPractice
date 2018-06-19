package com.chetan.javaPractice;

import java.util.Collections;

interface Addable{
    int add(int a,int b);
}

public class LambadaFunctionDemo1{
    public static void main(String[] args) {

        // Multiple parameters in lambda expression
        Addable ad1=(a,b)-> {
            return a+b;
        };
        System.out.println(ad1.add(10,20));

        //In Java lambda expression, if there is only one statement, you may or may not use return keyword.
        //You must use return keyword when lambda expression contains multiple statements.
        Addable ad2=(a,b)->(a+b);
        System.out.println(ad2.add(10,20));

        // Multiple parameters with data type in lambda expression
        Addable ad3=(int a,int b)->(a+b);
        System.out.println(ad3.add(100,200));

    }
}

