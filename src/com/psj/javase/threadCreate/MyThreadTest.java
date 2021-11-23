package com.psj.javase.threadCreate;

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("用thread创建线程");
    }
}

public class MyThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}
