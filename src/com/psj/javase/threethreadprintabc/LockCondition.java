package com.psj.javase.threethreadprintabc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {
    private static volatile int count = 0;
    private static Lock lock = new ReentrantLock();
    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            while (count <= 100) {
                lock.lock();
                if (count <= 100 && count % 3 != 0) {
                    try {
                        a.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count <= 100) {
                    System.out.println("线程" + Thread.currentThread().getName() + "输出了A" +"-----" + count);
                    count++;
                    b.signalAll();
                }
                if (count > 100) {
                    a.signalAll();
                    b.signalAll();
                }
                lock.unlock();
            }
        }, "a").start();

        new Thread(() -> {
            while (count <= 100) {
                lock.lock();
                if (count <= 100 && count % 3 != 1) {
                    try {
                        b.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count <= 100) {
                    System.out.println("线程" + Thread.currentThread().getName() + "输出了B" +"-----" + count);
                    count++;
                    c.signalAll();
                }
                if (count > 100) {
                    a.signalAll();
                    b.signalAll();
                }
                lock.unlock();
            }
        }, "b").start();

        new Thread(() -> {
            while (count <= 100) {
                lock.lock();
                if (count <= 100 && count % 3 != 2) {
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count <= 100) {
                    System.out.println("线程" + Thread.currentThread().getName() + "输出了C" +"-----" + count);
                    count++;
                    a.signalAll();
                }
                if (count > 100) {
                    a.signalAll();
                    b.signalAll();
                }
                lock.unlock();
            }
        }, "c").start();
    }
}
