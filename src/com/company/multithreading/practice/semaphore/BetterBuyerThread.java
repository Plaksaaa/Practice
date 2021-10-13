package com.company.multithreading.practice.semaphore;

import java.util.concurrent.Semaphore;

public class BetterBuyerThread implements Runnable{

    private final Semaphore cashBoxes;

    public BetterBuyerThread(Semaphore cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {
//            захват монитора если получилось - выполняется код после метода
//            если нет - поток ждет в этой строчке
            cashBoxes.acquire();

            System.out.println(Thread.currentThread().getName() + "обслуживается в какой-то кассе");
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + "освобождает какую-то кассу");
//            освобождение монитора
            cashBoxes.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
