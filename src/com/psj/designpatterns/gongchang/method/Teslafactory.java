package com.psj.designpatterns.gongchang.method;

public class Teslafactory implements Carfactory {

    @Override
    public Car getcar() {
        return new Tesla();
    }
}
