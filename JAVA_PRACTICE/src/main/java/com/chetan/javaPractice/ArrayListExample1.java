package com.chetan.javaPractice;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample1 {
    public  static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();

        list1.add("RAM");
        list1.add("SHAM");
        list1.add("SITA");
        list1.add("GITA");

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Ajay");
        list2.add("Vijay");

        list1.add(4,"Ashish");

        Iterator<String> itr = list1.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("=========================================");


    }

}
