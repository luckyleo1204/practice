package com.test.murali;

import java.util.*;

public class comparatorExample {
    public static void main(String[] args) {
        List<student> al =new ArrayList<student>();
        al.add (new student(1,"Murali", 322));
        al.add (new student(2,"Kushi", 22));
        al.add (new student(1,"Zen", 32));
        al.add (new student(1,"Adam", 566));

        Collections.sort(al, (o1,o2)->o1.getMarks()-o2.getMarks());
        al.forEach(a-> System.out.println(a));
        System.out.println("\n====================================\n");

        Collections.sort(al,(o1,o2)->o1.getId()-o2.getId() );
        al.forEach(a-> System.out.println(a));
        System.out.println("\n====================================\n");

        Collections.sort(al,(o1,o2)->o1.getName().compareTo(o2.getName()) );
        al.forEach(a-> System.out.println(a));

    }
}

class student{
    private int id, marks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;



    public student(int id, String Name, int marks){
        this.id=id; this.name=Name; this.marks=marks;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return id == student.id && marks == student.marks && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marks, name);
    }
}