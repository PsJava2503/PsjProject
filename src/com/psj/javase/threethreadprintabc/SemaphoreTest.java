package com.psj.javase.threethreadprintabc;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private static Semaphore a = new Semaphore(1);
    private static Semaphore b = new Semaphore(0);
    private static Semaphore c = new Semaphore(0);


    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    a.acquire();
                    System.out.println("a");
                    b.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "a").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    b.acquire();
                    System.out.println("b");
                    c.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "b").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    c.acquire();
                    System.out.println("c");
                    a.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "c").start();
    }

}
