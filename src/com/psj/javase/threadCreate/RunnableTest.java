package com.psj.javase.threadCreate;

import java.util.Date;

public class RunnableTest {
    public static void main(String[] args) {
        Myrunnable myrunnable = new Myrunnable();
        Thread t1 = new Thread(myrunnable);
        Thread t2 = new Thread(myrunnable);
        t1.start();
        t2.start();

    }
}

class Myrunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("runnable "+new Date().toString());
    }
}
