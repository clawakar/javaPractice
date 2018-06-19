package com.chetan.javaPractice;

import java.util.*;

public class PriorityQueueExample1 {
    public static void main(String[] args) {
        PriorityQueue<Book> queue=new PriorityQueue<Book>();

        ArrayList<Book> bookArrayList = new ArrayList<>();
        HashSet<Book> bookHashSet = new HashSet<>();
        //Creating Books  
        Book b1=new Book(6,"Let us C","Yashwant Kanetkar","BPB",8);
        Book b2=new Book(5,"Operating System","Galvin","Wiley",6);
        Book b3=new Book(4,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book b4=new Book(3,"Let us C","Yashwant Kanetkar","BPB",8);
        Book b5=new Book(2,"Operating System","Galvin","Wiley",6);
        Book b6=new Book(1,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        //Adding Books to the queue
        queue.add(b1);
        queue.add(b2);
        queue.add(b3);
        queue.add(b4);
        queue.add(b5);
        queue.add(b6);

        System.out.println("Traversing the queue elements:");
        //Traversing queue elements  
        for(Book b:queue){
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
        /*
        queue.remove();
        System.out.println("After removing one Book record:");
        for(Book b:queue){
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
        */
    }
}

