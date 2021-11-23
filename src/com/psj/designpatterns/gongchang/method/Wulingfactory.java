package com.psj.designpatterns.gongchang.method;

public class Wulingfactory implements Carfactory {

    @Override
    public Car getcar() {
        return new WUling();
    }
}
