package com.test.javapractice;

import java.util.*;

public class demo1 {
    public static void main(String[] args) {
        String s[]={"Hello", "Kavitha", "James","zen"," ","james","James", "Srinivasa", "NavaKoti","Adam"};
        Set<String> set1=new TreeSet<>(Arrays.asList(s)); // Remove duplicates, null and sort the list
        set1.forEach(n-> System.out.println(n));
        System.out.println("\n=============================\n");
        Set<String> set2=new HashSet<>(Arrays.asList(s)); // Remove duplicates & null, inserting order not preserved.
        set2.forEach(n-> System.out.println(n));
        System.out.println("\n=============================\n");
        Set<String> set3=new LinkedHashSet<>(Arrays.asList(s));// Remove duplicates & null, inserting order is preserved.
        set3.forEach(n-> System.out.println(n));
        System.out.println("\n=============================\n");
    }
}
