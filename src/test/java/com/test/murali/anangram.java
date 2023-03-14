package com.test.murali;

import java.util.Arrays;

public class anangram {
    public static void main(String[] args) {
        String st1="Race", st2="Care";
        String str1=st1.toLowerCase();
        String str2=st2.toLowerCase();

        char[] a=str1.toCharArray();
        char[] b=str2.toCharArray();

        Arrays.sort(a);
        System.out.println(a);
        Arrays.sort(b);
        System.out.println(b);

        boolean result=Arrays.equals(a,b);

        if(result==true)
            System.out.println("given String "+st1+" and "+ st2+" are anagram");
        else
            System.out.println("given String "+st1+" and "+ st2+" are not anagram");
    }
}
