package com.test.javapractice;

public class bubbleSort {
    public static void main(String[] args) {
        int a[]={112,12,2,33,44,66,9,01,8,22};
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
            printArray(a);
        }
        for(int i: a)
            System.out.print(i+"\t");
    }

    private static void printArray(int[] a) {
        for(int i: a)
            System.out.print(i+"\t");
        System.out.println();

    }


}
