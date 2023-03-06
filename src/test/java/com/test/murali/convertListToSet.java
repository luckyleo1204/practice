package com.test.murali;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class convertListToSet {
    public static void main(String[] args) {
        List<Integer> al= Arrays.asList(1,2,3,1,2,3,4,5,6);
        al.forEach(a-> System.out.print(a+"\t"));
        System.out.println();

        Set<Integer> set1=new HashSet<>();
        for(Integer i:al){
            set1.add(i);
        }
        for(Integer i : set1)
            System.out.print(i+"\t");

        System.out.println();

        //Convert Int Array to Integer Array
        int input[]={1,2,3,1,2,3,4,5,6};
        List<Integer> al1=Arrays.stream(input).boxed().collect(Collectors.toList());
        List<Integer> al2= IntStream.of(input).boxed().collect(Collectors.toList());

        //Second approach:
        Map<Integer, Integer> map=new HashMap<>();
        for(Integer i : al){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }
        }
        List<Integer> newlist=new ArrayList<>();
       for(Integer i: map.keySet()){
           if(map.get(i)==1)
               newlist.add(i);

       }

       newlist.forEach(a-> System.out.print(a+"\t"));
        System.out.println();

       Integer a[]={1,2,3,1,2,3,4,5,6};
       Set<Integer> set2=new HashSet<>(Arrays.asList(a));
       set2.forEach(x-> System.out.print(x+"\t"));

        System.out.println();

        Integer a1[]={1223,21,322,132,277,23,43435,634,22,21,9,8,11,9};
        Arrays.sort(a1);
        Arrays.stream(a1).toList().stream().forEach(n-> System.out.print(n+"\t"));
        System.out.println();
        Arrays.stream(a1).toList().stream().collect(Collectors.toList()).stream().distinct().forEach(m-> System.out.print(m+"\t"));



    }
}
