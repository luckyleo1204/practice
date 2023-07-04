package com.test.javapractice.mapDemo;

import com.beust.ah.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class comparatorDemo {
    public static void main(String[] args) {
        ArrayList<Student1> arrayList=new ArrayList<>();
        arrayList.add(new Student1(10,"Girlish",560));
        arrayList.add(new Student1(22,"Zen",999));
        arrayList.add(new Student1(9,"Rajesh",734));
        arrayList.add(new Student1(99,"Mohan",777));

        Collections.sort(arrayList, (o1,o2)->o1.getId()-o2.getId());
        arrayList.forEach(n-> System.out.println(n));
        System.out.println("\n================================\n");
        Collections.sort(arrayList,(o1,o2)->o1.getName().compareTo(o2.getName()));
        arrayList.forEach(n-> System.out.println(n));
        System.out.println("\n================================\n");
        Collections.sort(arrayList,(o1,o2)->o1.getMarks()-o2.getMarks());
        arrayList.forEach(n-> System.out.println(n));
        System.out.println("\n================================\n");
        Collections.sort(arrayList, new Comparator<Student1>() {
                    @Override
                    public int compare(Student1 o1, Student1 o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                arrayList.forEach(n -> System.out.println(n));
        System.out.println("\n============java 8====================\n");
        Comparator<Student1> cm2=Comparator.comparing(Student1::getMarks);
        Collections.sort(arrayList,cm2);
        arrayList.forEach(n-> System.out.println(n));
        System.out.println("\n================================\n");

        System.out.println("\n=============java 8===================\n");

        Comparator<Student1> cm1=Comparator.comparing(Student1::getName,Comparator.nullsFirst(String::compareTo));
        Collections.sort(arrayList,cm1);
        arrayList.forEach(n-> System.out.println(n));
        System.out.println("\n================================\n");

    }
}


class Student1{
    int id, marks;
    String name;

    public Student1(int id, String name,int marks) {
        this.id = id;
        this.marks = marks;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Student1 setId(int id) {
        this.id = id;
        return this;
    }

    public int getMarks() {
        return marks;
    }

    public Student1 setMarks(int marks) {
        this.marks = marks;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student1 setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "id=" + id +
                ", marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }
}