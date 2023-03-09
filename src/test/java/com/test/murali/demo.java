package com.test.murali;

import java.util.*;

public class demo {
    public static void main(String[] args) {
        ArrayList<Integer> al=new ArrayList<>(Arrays.asList(1,33,2,1,5,6,8,2,1,99));
        ArrayList<String> al1=new ArrayList<>(Arrays.asList("Kavitha","Murali","Kavitha","Kushi"));

        for(String i: removeDupBySet(al1)){
            System.out.print(i+"\t");
        }

    }

    public static <T>ArrayList<T> removeDup(ArrayList<T> t){
        ArrayList<T> newList=new ArrayList<>();
        for(T element:t)
        {
            if(!newList.contains(element)){
                newList.add(element);
            }
        }
        return newList;
    }

    public static <T> Set<T> removeDupBySet(ArrayList<T> t){
        Set<T> newList=new LinkedHashSet<>();
        newList.addAll(t);
        return newList;
    }
}

