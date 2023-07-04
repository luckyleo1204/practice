package com.test.javapractice;

public class isStringPalorNot {
    public static void main(String[] args) {
        String s="LEVEL";boolean ispal=true;
        char[] c=s.toCharArray();
        int left=0, right=c.length-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                ispal=false; break;
            }
            else{
                left++; right--;
            }

        }
        if(ispal==true)
            System.out.println("given string is pal");
        else
            System.out.println("given string is not pal");
    }
    }

