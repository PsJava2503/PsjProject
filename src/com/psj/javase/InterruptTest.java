package com.psj.javase;

public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println(111);
            }
        });
        t1.start();
        Thread.sleep(10);
        t1.interrupt();
    }
}
