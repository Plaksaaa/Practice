package com.company.multithreading.practice.queue_task;

import java.util.concurrent.BlockingQueue;

public class BetterBuyerThread implements Runnable{

    private final BlockingQueue<CashBox> cashBoxes;

    public BetterBuyerThread(BlockingQueue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {
//            возвращает и удаляет из головы очереди и ожидает если не оказалось элемента,
//            до тех пор пока не окажется свободного элемента ждет.
            CashBox cashBox = cashBoxes.take();
//            если поток прерывается нужно в finally его вернуть
            System.out.println(Thread.currentThread().getName() + "обслуживается в кассе" + cashBox);
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + "освобождает кассу" + cashBox);
            cashBoxes.add(cashBox);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
