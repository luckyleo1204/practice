package com.test.javapractice.mapDemo;

import com.beust.ah.A;

import java.util.ArrayList;
import java.util.Collections;

class student implements Comparable<student>{
    public String name;

    public student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(student s) {
        return name.compareTo(s.name);
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class ComparableDemo {

    public static void main(String[] args) {
        ArrayList<student> al=new ArrayList<>();
        al.add(new student("Murali"));
        al.add(new student("Viru"));
        al.add(new student("Saurav"));
        al.add(new student("Mukesh"));
        al.add(new student("Tahir"));

        Collections.sort(al);
        al.forEach(n-> System.out.println(n));

        Collections.sort(al);
        al.forEach(n-> System.out.println(n));
    }

}

