package com.company.multithreading.practice.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class TaskDemo {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();

        Thread producer = new Thread(new ProducerThread(queue));
        Thread consumer = new Thread(new ConsumerThread(queue));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
