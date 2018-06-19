package com.chetan.javaPractice;

import java.util.HashSet;
import java.util.LinkedHashSet;

class Book2 {
    int id;
    String name;
    int quantity;

    public Book2(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

}
public class HashSet_LinkedHashSet {

    public static void main(String[] args) {

        Book2 b1 = new Book2(1, "SHAMCHI AAI", 2);
        Book2 b2 = new Book2(2, "SANE GURUJI", 5);
        Book2 b3 = new Book2(3, "AGNI PANKH", 10);

        HashSet<Book2> book2HashSet = new HashSet<Book2>();
        book2HashSet.add(b1);
        book2HashSet.add(b2);
        book2HashSet.add(b3);
        for(Book2 i : book2HashSet) {
            System.out.println("BookId : " + i.id + "  Book name : " + i.name + "  Book quantity :" + i.quantity);
        }


        LinkedHashSet<Book2> book2LinkedHashSet = new LinkedHashSet<Book2>();
        book2LinkedHashSet.add(b1);
        book2LinkedHashSet.add(b2);
        book2LinkedHashSet.add(b3);

        for(Book2 i : book2LinkedHashSet) {
            System.out.println("BookId : " + i.id + "  Book name : " + i.name + "  Book quantity :" + i.quantity);
        }

        book2LinkedHashSet.forEach(
                (n)->System.out.println(n.toString())
        );
        }


}

