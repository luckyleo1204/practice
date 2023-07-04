package com.test.javapractice;

public class defualtDemo {
    public static void main(String[] args) {
        A a=new A();
        a.show();
    }
}

class A extends C implements i,j
{

}
interface i{
    default void show(){
        System.out.println("inside i interface");
    }

}

interface j{
    default void show(){
        System.out.println("inside j interface");
    }

}

class C{
    public void show(){
        System.out.println("inside c class");
    }
}