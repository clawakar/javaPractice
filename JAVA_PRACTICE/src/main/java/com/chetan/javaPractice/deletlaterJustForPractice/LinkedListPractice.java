package com.chetan.javaPractice.deletlaterJustForPractice;

import java.util.*;

public class LinkedListPractice {

    public static void main(String [] args){
        LinkedList<String> l = new LinkedList<>();

        l.add("Ram");
        l.add("Sham");
        l.add("Gita");
        l.add("Sita");
        l.add("Sham");


        Iterator i = l.listIterator(1);
        while(i.hasNext()) {
            System.out.println(i.next());
        }

        String s = l.peekLast();
        System.out.println(s);

        l.offerFirst("ajay");
        System.out.println(l);

        l.remove("Sham");
        l.pollFirst();
        System.out.println(l);
//        l.clear();
//        System.out.println("....." + l);
        Collections.swap(l, 1, 3);
        System.out.println(l);

        Collections.shuffle(l);
        System.out.println(l);

        LinkedList l2 = (LinkedList) l.clone();
        Collections.swap(l, 1, 3);
        System.out.println(l + "\n" + l2);

        ArrayList<String> a = new ArrayList<String>(l);
        System.out.println(a);
        String str = "Ram";
        System.out.println(l.indexOf(str));
        l.set(l.indexOf(str),"Rajit");
        System.out.println(l);


    }
//    void replace(LinkedList<String> l , String s1, String s2) {
//        for (String s3 : l) {
//            if(s3.equals(s1)) {
//                l.set(l.indexOf(s3), s1,s2);
//            }
//
//        }
// }
}
