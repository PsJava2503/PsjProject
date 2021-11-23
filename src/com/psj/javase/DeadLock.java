package com.psj.javase;

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        String a = "1";
        String b = "2";
        Thread t1 =  new Thread(() -> {
            synchronized (a) {
                System.out.println("线程1得到a");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {

                }
            }
        }, "1");
        Thread t2 = new Thread(() -> {
            synchronized (b) {
                System.out.println("线程2得到b");
                synchronized (a) {

                }
            }
        }, "2");
        t1.start();
        t2.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
