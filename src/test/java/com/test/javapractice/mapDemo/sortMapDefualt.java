package com.test.javapractice.mapDemo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class sortMapDefualt {

    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(101,"Muali");
        map.put(121,"Rajesh");
        map.put(105,"Binay");

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        System.out.println("\n===============================\n");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println);
        System.out.println("\n===============================\n");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        System.out.println("\n===============================\n");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

    }
}
