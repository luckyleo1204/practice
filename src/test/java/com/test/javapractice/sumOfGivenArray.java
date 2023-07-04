package com.test.javapractice;

public class sumOfGivenArray {

    public static void main(String[] args) {
        int a[]={2,7,11,15 };
        int x=18;
        int sum=0;
        String finalStr="";
        for(int i=0;i<a.length;i++){
            if(!(sum==x)){
                sum=sum+a[i];
                System.out.print(finalStr+a[i]+"\t");
            }
        }

    }
}
