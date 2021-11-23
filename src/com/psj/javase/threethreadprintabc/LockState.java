package com.psj.javase.threethreadprintabc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockState {
    private static Lock lock = new ReentrantLock();
    private static volatile int count = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            while (count <= 100) {
                lock.lock();
                if (count <= 100 && count % 3 == 0) {
                    System.out.println("线程" + Thread.currentThread().getName() + "输出了A" +"-----" + count);
                    count++;
                }
                lock.unlock();
            }
        }, "a").start();

        new Thread(() -> {
            while (count <= 100) {
                lock.lock();
                if (count <= 100 && count % 3 == 1) {
                    System.out.println("线程" + Thread.currentThread().getName() + "输出了B" +"-----" + count);
                    count++;
                }
                lock.unlock();
            }
        }, "b").start();

        new Thread(() -> {
            while (count <= 100) {
                lock.lock();
                if (count <= 100 && count % 3 == 2) {
                    System.out.println("线程" + Thread.currentThread().getName() + "输出了C" +"-----" + count);
                    count++;
                }
                lock.unlock();
            }
        }, "c").start();
    }
}
