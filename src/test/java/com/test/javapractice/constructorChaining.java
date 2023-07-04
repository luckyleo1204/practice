package com.test.javapractice;

public class constructorChaining {

    public static void main(String[] args) {
        Temp a=new Temp();
    }

}


class Temp{
    public Temp(){
        this(5);
        System.out.println("In Defualt Constructor");
    }

    public Temp(int i){
        this(5,6);
        System.out.println("One Argument Constructor"+ i);
    }

    public Temp(int i, int j){
        System.out.println("two Argument Constructor"+ (i+j));
    }
}