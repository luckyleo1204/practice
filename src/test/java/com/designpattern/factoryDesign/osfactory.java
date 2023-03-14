package com.designpattern.factoryDesign;

import java.awt.image.BandCombineOp;

public class osfactory {

    public os getInstance(String str){
        if(str.equals("secure"))
            return new ios();
        if(str.equals("famout"))
            return new android();
        return null;
    }
}
