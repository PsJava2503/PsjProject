package com.psj.designpatterns.gongchang.chouxiang;

public class Client {

    public static void main(String[] args) {
        System.out.println("===============小米系列================");
        Xiaomifactory xiaomifactory = new Xiaomifactory();
        Iphoneproduct phone = xiaomifactory.product();
        phone.callup();
        phone.sendsms();
        IRouterproduct router = xiaomifactory.router();
        router.openwifi();
        router.setting();


        System.out.println("===============小米系列================");
        Huaweifactory huaweifactory = new Huaweifactory();
        Iphoneproduct phone1 = huaweifactory.product();
        phone1.callup();
        phone1.sendsms();
        IRouterproduct router1 = huaweifactory.router();
        router1.openwifi();
        router1.setting();
    }


}
