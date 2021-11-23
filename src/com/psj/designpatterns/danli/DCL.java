package com.psj.designpatterns.danli;

public class DCL {
    private volatile static DCL instance;

    private void DCL() {
    }

    public static DCL getInstance() {
        if (instance == null) {
            synchronized (DCL.class) {
                if (instance == null) {
                    instance = new DCL(); // 懒加载
                }
            }
        }
        return instance;
    }
}
