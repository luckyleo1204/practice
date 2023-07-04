package com.test.javapractice;

public class aaabbccadbba {
    public static void main(String[] args) {
        String str="aaabbccadbba";
        String fstr=str.toLowerCase()+ " ";
        char[] cr=fstr.toCharArray();
        String finalString=" ";
        int count=1;

        for(int i=0;i<cr.length-1;i++){
            if(cr[i]==cr[i+1]){
                count++;
            }else{
                System.out.print(finalString+cr[i]+count+"\t");
                count=1;
            }
        }
    }
}
