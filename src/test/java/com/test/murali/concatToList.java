package com.test.murali;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class concatToList {
    public static void main(String[] args) {
        String[] an={"Dog", "Cat"};
        String[] an1={"Bird", "Cow", "Moose"};
        String an2="";
        for(String i: an){
            an2=an2+i+"\t";
        }
        for(String i: an1){
            an2=an2+i+"\t";
        }

        String[] an3= Stream.concat(Arrays.stream(an),Arrays.stream(an1)).toArray(String[] :: new);
        for(String i: an3)
            System.out.print(i+"\t");
    }
}
