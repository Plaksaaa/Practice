package com.company.multithreading.practice.producer_consumer;

import java.util.Queue;

public class ProducerThread implements Runnable {

    private final Queue<Integer> list;

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (list.size() < 10) {
                    int randomAddValue = RandomUtil.getRandom();
                    list.add(randomAddValue);
                    System.out.println("Producer adds value : " + randomAddValue + " Size : " + list.size());
                } else {
                    System.out.println("Producer does nothing");
                }
                list.notifyAll();
                try {
                    int randomWaitValue = RandomUtil.getRandom();
                    System.out.println("Producer is waiting : " + randomWaitValue);
                    list.wait(randomWaitValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
