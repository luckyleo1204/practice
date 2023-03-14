package com.test.murali;

public class MainOverloadExample{
    public static void main(String[] args) {
        System.out.println("in string main");
        int[] x={5};
        main(x);
    }

    public static void main(int[] args) {
        System.out.println("in int main ");
    }
}
