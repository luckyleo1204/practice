package com.test.javapractice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflectionDemo {

    //use to test class/method which is private , but not used in normal scenario
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        Class c=Class.forName("com.test.javapractice.Test");
        Test t= (Test) c.newInstance();
        Method m=c.getDeclaredMethod("show", null);
        m.setAccessible(true);
        m.invoke(t,null);

        System.out.println(c.getSuperclass());
        System.out.println(c.getSuperclass());
        System.out.println(c.getInterfaces());



    }
}
