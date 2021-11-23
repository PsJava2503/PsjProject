package com.psj.designpatterns.gongchang.chouxiang;

public class Xiaomiphone implements Iphoneproduct {
    @Override
    public void start() {
        System.out.println("开启小米手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米手机");
    }

    @Override
    public void callup() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void sendsms() {
        System.out.println("小米手机发短信");
    }
}
