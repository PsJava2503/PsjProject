package com.psj.designpatterns.gongchang.chouxiang;

public class Huaweiphone implements Iphoneproduct {
    @Override
    public void start() {
        System.out.println("开启华为手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为手机");
    }

    @Override
    public void callup() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void sendsms() {
        System.out.println("华为手机发短信");
    }
}
