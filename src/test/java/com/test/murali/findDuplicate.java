package com.test.murali;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class findDuplicate {
    public static void main(String[] args) {
        String s="java2novoice";
        char[] c=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for(char i: c){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }

        for(Character i : map.keySet()){
            if(map.get(i)>1)
                System.out.println(i+"==>"+map.get(i));
        }

    }
}
