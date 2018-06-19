package com.chetan.javaPractice.equalsMethod;

class Complex {
    public double re, im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
}

// Driver class to test the Complex class
public class EqualMethodDemo1 {
    public static void main(String[] args) {
        Complex c1 = new Complex(10, 15);
        Complex c2 = new Complex(10, 15);
        if (c1 == c2) {
            System.out.println("Equal ");
        } else {
            System.out.println("Not Equal ");
        }

        Complex c3 = c1;
        c3.re = 11.2;
        System.out.println(c1 + "  " + c1.re + " " +c1.im);
        System.out.println(c3 + "  " + c3.re + " " +c3.im);
    }


}


