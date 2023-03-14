package com.designpattern.builderDesign;

public class studentBuilder {
    public int id, marks, phonenumber;
    public String Name, Address;

    public studentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public studentBuilder setMarks(int marks) {
        this.marks = marks;
        return this;
    }

    public studentBuilder setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }

    public studentBuilder setName(String name) {
        Name = name;
        return this;
    }
    public studentBuilder setAddress(String address) {
        Address = address;
        return this;
    }

    public student getStudent(){
        return new student(id,marks,phonenumber,Name, Address);
    }
}
