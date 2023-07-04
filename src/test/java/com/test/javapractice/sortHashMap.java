package com.test.javapractice;

import java.util.*;

public class sortHashMap {
    public static void main(String[] args) {
        //implementation of HashMap
        HashMap<Integer, String> hm=new HashMap<Integer, String>();
//addding keys and values to HashMap
        hm.put(23, "Yash");
        hm.put(17, "Arun");
        hm.put(15, "Swarit");
        hm.put(9, "Neelesh");
        System.out.println("Before Sorting");
        for(Integer i: hm.keySet())
            System.out.println("Roll no:  "+i+"     name:   "+hm.get(i));

        System.out.println("\n==================================\n");

        TreeMap<Integer,String> tm=new TreeMap<>(hm); //Sorting Map using Tree MAP.
        System.out.println("Sorted using TreeMap");
        for(Integer i: tm.keySet())
            System.out.println("Roll no:  "+i+"     name:   "+hm.get(i));
        System.out.println("\n==================================\n");

        // Step1 : 
        List list = new LinkedList(hm.entrySet());

        //Comparator
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());

            }
        });

        //converting list back to map
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();)
        {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }

        for(Object i: sortedHashMap.keySet())
            System.out.println("Roll no:  "+i+"     name:   "+sortedHashMap.get(i));
        System.out.println("\n==================================\n");


    }
}
