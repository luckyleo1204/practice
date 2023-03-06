package com.test.murali;

public class aaabbccddaab {
    public static void main(String[] args) {
        String s="aaabbccddaab"+" ";
        char[] c=s.toCharArray();
        String finalStr= " ";
        int count=1;

        for(int i=0;i<c.length-1;i++){
            if(c[i]==c[i+1]){
                count++;
            }else{
                System.out.print(finalStr+c[i]+count+"\t");
                count=1;
            }
        }

    }
}
