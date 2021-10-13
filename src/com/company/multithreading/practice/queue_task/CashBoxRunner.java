package com.company.multithreading.practice.queue_task;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CashBoxRunner {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<CashBox> cashBoxes = new ArrayBlockingQueue<>(2, true,
                List.of(new CashBox(), new CashBox()));

        List<Thread> threads = Stream.of(
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes),
                new BuyerThread(cashBoxes)
        )
                .map(Thread::new)
                .peek(Thread::start)
                .collect(toList());

        for (Thread thread : threads) {
            thread.join();
        }

    }
}
