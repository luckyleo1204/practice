package com.test.murali;



import java.util.ArrayList;
import java.util.Arrays;

public class removeDuplicate {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,2,2,22,343,22,2));
        ArrayList<Integer> newlist=removedup(list);
        newlist.forEach(a-> System.out.print(a+"\t"));
    }
      public static <T>ArrayList<T> removedup(ArrayList<T> t){
        ArrayList<T> al=new ArrayList<T>();
        for(T element: t){
            if(!al.contains(element))
                al.add(element);
        }
        return al;
      }
}