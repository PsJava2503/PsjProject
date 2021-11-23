package com.psj.designpatterns.gongchang.simple;

public class Consumer {
    public static void main(String[] args) {
        Car wuling = Carfactory.getcar("wuling");
        Car tesla = Carfactory.getcar("tesla");
        wuling.name();
        tesla.name();
    }
}

class WUling implements Car {

    @Override
    public void name() {
        System.out.println("wulinghongguang");
    }
}

class Tesla implements Car {

    @Override
    public void name() {
        System.out.println("tesla");
    }
}

class Carfactory {
    public static Car getcar(String car) {
        if (car.equals("wuling")) {
            return new WUling();
        } else if (car.equals("tesla")) {
            return new Tesla();
        } else {
            return null;
        }
    }
}
