package com.psj.designpatterns.jingtaidaili;

public class Client {

    public static void main(String[] args) {
        Host host = new Host();

        Proxy proxy = new Proxy(host);
        proxy.see();
        proxy.rent();
    }
}
