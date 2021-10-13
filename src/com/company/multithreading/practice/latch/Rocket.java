package com.company.multithreading.practice.latch;

import java.util.concurrent.CountDownLatch;

public class Rocket implements Runnable{
    private final CountDownLatch downLatch;

    public Rocket(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    @Override
    public void run() {
        System.out.println("Ракета готовится...");
        try {
            downLatch.await();
            System.out.println("ПУСК");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
