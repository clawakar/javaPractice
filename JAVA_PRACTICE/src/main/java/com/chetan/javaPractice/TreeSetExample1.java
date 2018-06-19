package com.chetan.javaPractice;

import java.util.*;

public class TreeSetExample1 {
    public static void main(String[] args) {
        Set<Book> set=new TreeSet<Book>();
        //Creating Books
        Book b1=new Book(121,"Let us C","Yashwant Kanetkar","BPB",8);
        Book b2=new Book(233,"Operating System","Galvin","Wiley",6);
        Book b3=new Book(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book b4=new Book(121,"Shyamchi Aai","Sane Guruji","Unknown",10);
        Book b5=new Book(122,"Shyamchi Aai","Sane Guruji","Unknown",10);

        //Adding Books to TreeSet
        set.add(b1);
        set.add(b2);
        set.add(b3);
        set.add(b4);    //b4 object will not get add as Book compareTo method is based on ID, and b1 and b4 book id is same
        set.add(b5);

        //Traversing TreeSet
        for(Book b:set){
            System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
        }

    }

}

