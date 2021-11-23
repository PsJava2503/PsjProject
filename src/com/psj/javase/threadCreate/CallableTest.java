package com.psj.javase.threadCreate;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        Mycall mycall = new Mycall();
        FutureTask<Integer> futureTask = new FutureTask<>(mycall);
        FutureTask<Integer> futureTask2 = new FutureTask<>(mycall);
        Thread t1 = new Thread(futureTask);
        Thread t2 = new Thread(futureTask2);
        t1.start();
        t2.start();
    }
}

class Mycall implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println("call "+new Date());
        return 1;
    }
}
