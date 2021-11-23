package com.psj.designpatterns.danli;

//懒汉
public class LazyMan {

    private static LazyMan instance;

    private void Lazyman() {}


    public static LazyMan getInstance() {//线程安全懒汉单例直接加synchronized
        if (instance == null) {
            instance = new LazyMan();
        }
        return instance;
    }

}
