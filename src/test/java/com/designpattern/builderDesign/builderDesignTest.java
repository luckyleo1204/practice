package com.designpattern.builderDesign;

public class builderDesignTest {
    public static void main(String[] args) {
        student s=new studentBuilder().setId(1).setMarks(232).setName("Murali").getStudent();
        System.out.println(s);
    }
}
