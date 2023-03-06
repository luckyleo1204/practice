package com.test.murali;

public class userDefinedExceptionDemo{
    public static void main(String[] args) {
       try{
           throw new mexception("hiMurali");
       }catch(mexception e){
           System.out.println("caught");
           System.out.println(e.getMessage());
       }

    }
}

class mexception extends Exception{

    public mexception(String s){
        super(s);
    }
}