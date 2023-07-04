package com.test.javapractice.mapDemo;

import java.util.HashMap;
import java.util.Map;

public class Book {
    int id;
    String name,author,publisher;
    int quantity;

    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
}

class mapExampleDemo{
    public static void main(String[] args) {
        Map<Integer, Book> map=new HashMap<>();
        Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);
        Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book b3=new Book(103,"Operating System","Galvin","Wiley",6);

        map.put(1,b1);
        map.put(2,b2);
        map.put(3,b3);

        for(Map.Entry<Integer,Book> i: map.entrySet()){
            int key=i.getKey();
            Book b=i.getValue();
            System.out.println(key+"Details:");
            System.out.println(b.id+"\t"+b.name+"\t"+b.author+"\t"+b.publisher+"\t"+b.quantity);
        }


    }
}
