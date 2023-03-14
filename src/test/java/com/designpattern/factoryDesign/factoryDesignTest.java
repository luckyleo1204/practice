package com.designpattern.factoryDesign;

public class factoryDesignTest {

    public static void main(String[] args) {
        osfactory osf=new osfactory();
        os obj=osf.getInstance("secure");
        obj.spec();
    }
}
