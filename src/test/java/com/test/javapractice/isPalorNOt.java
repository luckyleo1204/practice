package com.test.javapractice;

public class isPalorNOt {
    public static void main(String[] args) {
        int x=121, temp=x, sum=0;boolean isprime=true;
        while(x>0){
            int rem=x%10;
            sum=(sum*10)+rem;
            x=x/10;
        }

        if(temp==sum)
            System.out.println("give no is palindrom");
        else
            System.out.println("give no is not palindrom");
    }
}
