package com.psj.designpatterns.gongchang.chouxiang;

public class Xiaomirouter implements IRouterproduct {
    @Override
    public void start() {
        System.out.println("启动小米路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米路由器");
    }

    @Override
    public void openwifi() {
        System.out.println("打开小米wifi");
    }

    @Override
    public void setting() {
        System.out.println("设置小米wifi");
    }
}
