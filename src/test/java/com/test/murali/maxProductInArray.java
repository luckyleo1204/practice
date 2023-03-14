package com.test.murali;

public class maxProductInArray {
    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 6, 8, 7, 0,-8,-9};
        int n = arr.length;
        maxProduct(arr, n);
    }

    private static void maxProduct(int[] arr, int n) {
        if(n<2)
            System.out.println("No pair exists.");

        int a=arr[0], b=arr[1];
        for(int i=0;i<arr.length;i++){
            for(int j=i+1; j<arr.length;j++){
                if(arr[i]*arr[j]>a*b){
                    a=arr[i];
                    b=arr[j];
                }
            }
        }
        System.out.println("Max product pair is {" +
                a + ", " + b + "}");
    }
}
