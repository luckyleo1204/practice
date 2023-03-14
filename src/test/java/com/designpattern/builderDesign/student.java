package com.designpattern.builderDesign;

public class student {
    public int id, marks, phonenumber;
    public String Name, Address;

    public student(int id, int marks, int phonenumber, String name, String address) {
        this.id = id;
        this.marks = marks;
        this.phonenumber = phonenumber;
        Name = name;
        Address = address;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", marks=" + marks +
                ", phonenumber=" + phonenumber +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
