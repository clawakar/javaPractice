package com.chetan.javaPractice.deletlaterJustForPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListPractice {

    public static void main(String [] args) {

        ArrayList<Integer> l = new ArrayList(30);
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        l.add(60);
        l.add(70);
        l.add(0,5);

        /*
        System.out.println(l);
        l.add(0,3);
        System.out.println(l);
        l.set(0,2);
        System.out.println(l);

        int j = 0;
        for(Integer i : l) {
            if(i == 30) {
                l.set(j,35);
            }
            j++;
        }
        System.out.println(l);
 */
        List<Integer> l2 = l.subList(3, 5);
        System.out.println(l2);
       Collections.swap(l,1,5);
        System.out.println(l);

       ArrayList<Integer> l3 = (ArrayList<Integer>) l.clone();

       System.out.println("l3 : " + l3 );

        System.out.println(l.subList(3, 5));

        // Object i[] = l.toArray();
        // System.out.println((Integer) i[0]);

        System.out.println("Size : " + l.size());
        l.trimToSize();
        l.ensureCapacity(19);

    }
}
