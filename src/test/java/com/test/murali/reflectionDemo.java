package com.test.murali;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static freemarker.template.utility.ClassUtil.forName;

public class reflectionDemo {

    //use to test class/method which is private , but not used in normal scenario
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        Class c=Class.forName("com.test.murali.Test");
        Test t= (Test) c.newInstance();
        Method m=c.getDeclaredMethod("show", null);
        m.setAccessible(true);
        m.invoke(t,null);

        System.out.println(c.getSuperclass());
        System.out.println(c.getSuperclass());
        System.out.println(c.getInterfaces());



    }
}
