package com.psj.designpatterns.danli;

//饿汉
public class Hungry {
    private static Hungry hungry = new Hungry();
    private Hungry() {
    }

    public static Hungry getInstance() {
        return hungry;
    }

}
