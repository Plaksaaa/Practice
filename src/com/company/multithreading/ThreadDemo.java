package com.company.multithreading;

public class ThreadDemo {
    public static void main(String[] args) {
        var simpleThread = new SimpleThread();
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
        var simpleRunnable = new Thread(new SimpleRunnable());
        var thread = new Thread(() -> System.out.println("Hello from lambda: " + Thread.currentThread().getName()));

        simpleThread.start();
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState());

        simpleRunnable.start();
        thread.start();
        try {
            simpleThread.join();
            System.out.println(simpleThread.getName() + ": " + simpleThread.getState());

            simpleRunnable.join();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());

    }
}
