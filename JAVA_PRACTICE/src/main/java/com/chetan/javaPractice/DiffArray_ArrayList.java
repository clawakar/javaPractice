package com.chetan.javaPractice;

// A Java program to demonstrate differences between array
// and ArrayList
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class DiffArray_ArrayList
{
    public static void main(String args[])
    {
    /* ........... Normal Array............. */
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        for(Integer i : arr) {
            System.out.println("arr : " + i);
        }

    /*............ArrayList..............*/
        // Create an arrayList with initial capacity 2
        ArrayList<Integer> arrL = new ArrayList<Integer>(2);
        ArrayList<Integer> arrL2 = new ArrayList<Integer>();

        /* check the default capacity of the ArraList*/
        System.out.println("initialy arrL size : " + arrL.size());
        //System.out.println("arrL capacity : " + arrL.);

        System.out.println("initialy arrL2 size : " + arrL2.size());

        // Add elements to ArrayList
        arrL.add(1);
        arrL.add(2);
        arrL2.add(5);
        arrL2.add(7);

        System.out.println("after initialization arrL size : " + arrL.size());
        System.out.println("after initialization arrL2 size : " + arrL2.size());

        arrL.addAll(arrL2);

        System.out.println("after adding arraL2 in arraL, size of arraL : " + arrL.size());

        // Access elements of ArrayList
        for (Integer i : arrL) {
            System.out.println("arrL : " + i);
        }

        //printing elements without for loop
        System.out.println("arr : " + Arrays.toString(arr));
        System.out.println("arrL : " + arrL);
        System.out.println("arrL2 : " + arrL2);

        Arrays.fill(arr,1,2,5);
        System.out.println("arr : " + Arrays.toString(arr));


        //listIterator

        ListIterator l1 = arrL.listIterator();
        while(l1.hasNext()) {
            System.out.println("value stored of arrL at "+ l1.nextIndex()+ " is " + l1.next());
        }

        System.out.println("========================================================");
        List<Integer> arrL3 = new ArrayList<Integer>();
        arrL3.add(11);
        arrL3.add(12);


        /*
        We can add element at any point of time while traversing a list using ListIterator.
        */
        ListIterator l2 = arrL3.listIterator();
        //arrL3.addAll(arrL);      //java.util.ConcurrentModificationException
        while(l2.hasNext()) {
            System.out.println("value stored of arrL at "+ l2.nextIndex()+ " is " + l2.next());
        }

        System.out.println("========================================================");
        System.out.println(arrL3);

        System.out.println("========================================================");
        arrL3.addAll(arrL);
        ListIterator l3 = arrL3.listIterator();
        while(l3.hasNext()) {
            System.out.println("value stored of arrL at "+ l3.nextIndex()+ " is " + l3.next());
        }


        System.out.println("========================================================");
        List<Integer> arrL4 = new CopyOnWriteArrayList<Integer>();
        arrL4.add(111);
        arrL4.add(112);

        ListIterator l4 = arrL4.listIterator();
        arrL4.addAll(arrL);      //It works fine as arrL4 is CopyOnWriteArrayList but still l4 will refer to old copy of arrl4 [111, 112]
        while(l4.hasNext()) {
            System.out.println("value stored of arrL at "+ l4.nextIndex()+ " is " + l4.next());
        }

        System.out.println("========================================================");
        System.out.println(arrL4);

        /*
        We cannot add element to collection while traversing it using Iterator,
        It throws ConcurrentModificationException when you try to do it.
        */




    }
}

