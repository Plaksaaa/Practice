package com.company.multithreading.practice.producer_consumer;

import java.util.Queue;

public class ConsumerThread implements Runnable {

    private final Queue<Integer> list;

    public ConsumerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (!list.isEmpty()) {
                    Integer removedValue = list.remove();
                    System.out.println("Consumer gets value : " + removedValue + " Size : " + list.size());
                } else {
                    System.out.println("list is empty, consumer is waiting");
                }
                try {
                    int random = RandomUtil.getRandom();
                    System.out.println("Consumer is waiting : " + random);
                    list.notifyAll();
                    list.wait(random);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
