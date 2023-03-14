package com.test.murali;

public class singletonDemo {
    public static void main(String[] args) {
        singleton s=singleton.getInstance();
        s.display();

        singleton s1=singleton.getInstance();
        s1.display();


    }
}


class singleton{
    private  static volatile singleton obj=null;

    private singleton(){}

    public static singleton getInstance(){
        if(obj==null ) {
            synchronized (singleton.class) { //Here using synchronized makes sure that only one thread
                // check again as multiple threads
                // can reach above step
                if (obj == null)
                    return new singleton();
            }
        }
        return obj;
    }
    public static void display(){
        System.out.println(singleton.class.getName());
    }
}