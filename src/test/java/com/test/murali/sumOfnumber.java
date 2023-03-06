package com.test.murali;

public class sumOfnumber {
    public static void main(String[] args) {
        int sum=0, x=9754232;
        while(x>0){
            int rem=x%10;
            sum=sum+rem;
            x=x/10;
        }
        System.out.println("Sum of given number x"+x+"is :"+sum);
    }
}
