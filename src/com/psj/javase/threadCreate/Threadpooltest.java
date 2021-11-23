package com.psj.javase.threadCreate;

import java.util.concurrent.*;

public class Threadpooltest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName()+":"+"输出的结果");
        //通过线程池工厂创建线程数量为2的线程池
        ExecutorService service = Executors.newFixedThreadPool(2);
        //执行线程,execute()适用于实现Runnable接口创建的线程
        service.execute(new ThreadDemo4());
        service.execute(new ThreadDemo6());
        service.execute(new ThreadDemo7());
        //submit()适用于实现Callable接口创建的线程
        Future<String> task = service.submit(new ThreadDemo5());
        //获取call()方法的返回值
        String result = task.get();
        System.out.println(result);
        //关闭线程池
        service.shutdown();
    }
}

//实现Runnable接口
class ThreadDemo4 implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+"输出的结果");
    }

}

//实现Callable接口
class ThreadDemo5 implements Callable<String> {

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+"输出的结果");
        return Thread.currentThread().getName()+":"+"返回的结果";
    }

}

//实现Runnable接口
class ThreadDemo6 implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+"输出的结果");
    }

}

//实现Runnable接口
class ThreadDemo7 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + "输出的结果");
    }
}
