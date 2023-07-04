package com.test.javapractice;

public class intersectionof2Array {
    public static void main(String[] args) {
        int x[]={1,23,4,5,6,7};
        int y[]={343,31,1,34,5,6,7};
        int z[]=new int[x.length+y.length];
        int k=0;

        for(int i=0;i<x.length;i++){
            for(int j=0;j<y.length;j++){
                if(x[i]==y[j]){
                    z[k]=x[i];
                    k++;
                }else{
                    continue;
                }
            }
        }
        for(int i:z)
            System.out.print(i+"\t");
    }
}
