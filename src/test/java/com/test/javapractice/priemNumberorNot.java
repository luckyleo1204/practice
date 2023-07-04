package com.test.javapractice;

public class priemNumberorNot {
    public static void main(String[] args) {
        int x=31; boolean isprime=true;

        for(int i=2;i<x/2;i++){
            if(x%i==0){
                isprime=false;
                break;
            }
        }

        if(isprime==true)
            System.out.println("given no is prime");
        else
            System.out.println("given no is not prime");
    }
}
