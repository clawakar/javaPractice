package com.chetan.javaPractice.staticKeywordPractice;

public class StaticDemo1 {
    static int x;
    int y;

    // static block
    static {
        System.out.println("==============Static block : start =========");
        x = 10; // allowed in java
        //y = 30; // as y is not static member we can not access it from static block
        System.out.println("==============Static block : end =========");

    }

    //non static block
    {
        System.out.println("============== Non Static block : start =========");

        x = 20;
        y = 20;
        System.out.println(x + "\t" + y );

        System.out.println("==============Non Static block : start =========");

    }
    static void funtion1() {
        System.out.println("==============function1 =========");


    }

     void funtion2() {
         System.out.println("==============function2() : start =========");

         funtion1(); // we can access static menmbers from not static block or not static functions
         System.out.println("==============function2() : end =========");


     }

    public static void main(String[] args) {
        System.out.println("============== main() : start =========");

        // we can not access not static members from static block or static function directly (without object referance)
        funtion1(); // this allowed as function1 is static function
        x = 30; // this allowed as x is static variable
        //funtion2(); // not allowed as function2 is instance fuction can not be called from static function

        StaticDemo1 st1 = new StaticDemo1();
        st1.funtion2(); // this allowed we can call the instace fun ction or intstaice variabkle by using object only.
        st1.y = 30;

        System.out.println(x + "\t" + st1.y );
        System.out.println("============== main() : end =========");


    }
}
