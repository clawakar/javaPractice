package com.chetan.javaPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortArrayComparatorInterface implements Comparable<Integer>{

    public static  void main (String[] agrs) {
        Integer arr[] = {3345, 504, 201, 705, 3000, 900002, 10008, 100009};

        List<Integer> arrL = new ArrayList<Integer>();
        for(Integer i : arr) {
            arrL.add(i);
        }

        System.out.println("Before sorting arraL : "  + arrL);
        Collections.sort(arrL,new CompareWithLastDegit());
        System.out.println("After sorting arraL based on last degit : "  + arrL);

        Collections.sort(arrL);
        System.out.println("After sorting arraL based on integer value : "  + arrL);

        System.out.println("Printing arrL values using foreach and lambada expresssion");

        arrL.forEach(
                (n)->System.out.println(n)
        );

    }

    public int compareTo(Integer o) {
        return 0;
    }
}

class CompareWithLastDegit implements Comparator{

    public int compare(Object o1, Object o2) {
        Integer i1= (Integer) o1;
        Integer i2= (Integer) o2;
        if((i1 % 10) == (i2 % 10)) {
            return 0;
        }
        else if ((i1 % 10) > (i2 % 10)) {
            return 1;
        }
        else {
            return -1;
        }
    }
}


