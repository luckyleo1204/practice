package com.test.murali;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparatorDemo {
    public static void main(String[] args) {
        List<stud> al=new ArrayList<>();
        al.add(new stud(12, "Murali",232));
        al.add(new stud(1, "Kushi",545));
        al.add(new stud(22, "Root",343));
        al.add(new stud(21, "Geen",221));
        al.add(new stud(73, "Peach",99));
        al.add(new stud(92, "Rose",888));

        Collections.sort(al, new Comparator<stud>() {
            @Override
            public int compare(stud o1, stud o2) {
                return o1.getId()-o2.getId();
            }
        });

        al.forEach(n-> System.out.println(n));
        System.out.println("\n============================\n");
        Collections.sort(al,(o1,o2)->o1.getName().compareTo(o2.getName()));

        al.forEach(n-> System.out.println(n));
        System.out.println("\n============================\n");


    }
}

class stud{
    private int id, marks;
    private String name;

    public stud(int id, String name,int marks ) {
        this.id = id;
        this.marks = marks;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public stud setId(int id) {
        this.id = id;
        return this;
    }

    public int getMarks() {
        return marks;
    }

    public stud setMarks(int marks) {
        this.marks = marks;
        return this;
    }

    public String getName() {
        return name;
    }

    public stud setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }

}