package com.test.murali;

public class fibSeries {
    public static void main(String[] args) {
        int x=15;
        int fib[]=new int[x];
        fib[0]=1; fib[1]=1;
        for(int i=2;i<x;i++){
            fib[i]=fib[i-1]+fib[i-2];
            System.out.print(fib[i]+"\t");
        }


    }
}
