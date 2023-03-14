package com.test.murali;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class mapFrequency {
    public static void main(String[] args) {
        String[] chars = { "A", "B", "C", "A", "C", "A" };
        Map<String, Integer> freq = new HashMap<>();
        int prev=0;
        for(String i: chars){
            if(freq.get(i)!=null){
                prev=freq.get(i);
            }
            freq.put(i, prev+1);
        }
        System.out.println(freq);
        //approach 2:
//        for (String s: chars) {
//            freq.merge(s, 1L, Long::sum);
//        }
//        System.out.println(freq);

        //approach 3:
        System.out.println();
        Map<String, Long> freq1 = Stream.of(chars)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        System.out.println(freq1);

    }
}
