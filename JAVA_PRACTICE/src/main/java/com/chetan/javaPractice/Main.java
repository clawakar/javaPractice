package com.chetan.javaPractice;

public class Main {
    public static void main (String[] args) {

        SortArray sortArray = new SortArray();

        Integer i = new Integer(null);

        sortArray.getArray();
        System.out.println("array values in origenal order \n");
        sortArray.printArray();
        System.out.println("Sorting array by assending order \n ");
        sortArray.sortArrayByOrder(true);
        sortArray.printArray();
        System.out.println("Sorting array by desending order \n");
        sortArray.sortArrayByOrder(false);
        sortArray.printArray();


        /*
        SortArray s = new SortArray();
        System.out.println(sortArray.getClass().getName());
        System.out.println(i.getClass().getName());
        */

        //sortArray.printArray();
    }
}
