package com.test.murali;

public class findSecondMax {
    public static void main(String[] args) {
        int a[]={1,2,4,6,88,99,22,89};
        int max = 0,secondMax = 0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>max){
                secondMax=max;
                max=a[i];
            }else{
                if(secondMax<a[i]){
                    secondMax=a[i];

                }
            }
        }

        System.out.println("Second Max:"+secondMax);
    }
}
