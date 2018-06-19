package com.chetan.javaPractice.deletlaterJustForPractice;

import java.net.SocketPermission;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class HashSetPractice {
    public static void main(String [] args) {
        HashSet<String> hs = new HashSet<>();

        hs.add("Ram");
        hs.add("Sham");
        hs.add("Gita");
        hs.add("Sita");
        hs.add("Sham");

        System.out.println(hs.size());
//        hs.clear();
//        System.out.println(hs.isEmpty());

        ArrayList a = new ArrayList(hs);
        System.out.println(a);

        TreeSet<String> t = new TreeSet<String>(hs);
        System.out.println(t);
 //       System.out.println(t.descendingSet());

        Iterator i = t.descendingIterator();

        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("========================");
        System.out.println(t);
        System.out.println(t.lower("Sita"));

        TreeSet<String> t2 = new TreeSet<String>(t.tailSet("Gita", false));
        System.out.println(t2);

        t2.pollFirst();
        System.out.println(t2);

        System.out.println(t2.remove("Ram"));
        System.out.println(t2);



        //hs.size();

    }
}
