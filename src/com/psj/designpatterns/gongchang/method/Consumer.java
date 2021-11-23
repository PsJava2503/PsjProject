package com.psj.designpatterns.gongchang.method;

public class Consumer {

    public static void main(String[] args) {
        Car car1 = new Wulingfactory().getcar();
        Car car2 = new Teslafactory().getcar();


        car1.name();
        car2.name();


    }
}
