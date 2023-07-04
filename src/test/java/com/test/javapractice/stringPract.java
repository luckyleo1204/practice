package com.test.javapractice;

import java.util.HashMap;
import java.util.Map;

public class stringPract {
    public static void main(String[] args) {
        String s="Hello Murali and Kushi";

        for(int i=0;i<s.length();i++){
            System.out.print(s.charAt(s.length()-1-i));
        }

        System.out.println("\n========================\n");
       String s1[]=s.split(" ");
        for(int i=s1.length-1;i>=0;i--){
            System.out.print(s1[i]+"\t");
        }

        System.out.println("\n========================\n");

         char s2[]=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for(char i: s2){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        for(char j: map.keySet())
            System.out.print(j+":"+map.get(j)+"\t");




    }
}
