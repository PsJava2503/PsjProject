package com.psj.designpatterns.gongchang.chouxiang;

public class Xiaomifactory implements ProductFactory {
    @Override
    public Iphoneproduct product() {
        return new Xiaomiphone();
    }

    @Override
    public IRouterproduct router() {
        return new Xiaomirouter();
    }
}
