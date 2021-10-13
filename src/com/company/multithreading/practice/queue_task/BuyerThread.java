package com.company.multithreading.practice.queue_task;

import java.util.Queue;

//покупатели
public class BuyerThread implements Runnable {
//    ссылка у каждого покупателя на список(очередь) из касс в магазине

    private final Queue<CashBox> cashBoxes;

    public BuyerThread(Queue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {
//                захватываем монитор касс чтобы только один поток мог проверить доступные кассы
//                иначе будет NoSuchElementException т.к два потока удалят кассу из списка
            synchronized (cashBoxes) {
                while (true) {
                    if (!cashBoxes.isEmpty()) {
                        CashBox cashBox = cashBoxes.remove();
                        System.out.println(Thread.currentThread().getName() + "обслуживается в кассе" + cashBox);

                        cashBoxes.wait(5L);

                        System.out.println(Thread.currentThread().getName() + "освобождаю кассу" + cashBox);
//                возвращаю кассу в список доступных касс
                        cashBoxes.add(cashBox);
                        cashBoxes.notifyAll();
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + "ожидает свободную кассу");
                        cashBoxes.wait();
                    }
                }
            }
            //        проверяем есть ли свободная касса
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
