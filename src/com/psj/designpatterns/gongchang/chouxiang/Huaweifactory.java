package com.psj.designpatterns.gongchang.chouxiang;

public class Huaweifactory implements ProductFactory {
    @Override
    public Iphoneproduct product() {
        return new Huaweiphone();
    }

    @Override
    public IRouterproduct router() {
        return new Huaweirouter();
    }
}
