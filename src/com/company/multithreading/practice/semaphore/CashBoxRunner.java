package com.company.multithreading.practice.semaphore;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CashBoxRunner {

    public static void main(String[] args) throws InterruptedException {
        Semaphore cashBoxes = new Semaphore(2);
        List<Thread> threads = Stream.of(
                new BetterBuyerThread(cashBoxes),
                new BetterBuyerThread(cashBoxes),
                new BetterBuyerThread(cashBoxes),
                new BetterBuyerThread(cashBoxes),
                new BetterBuyerThread(cashBoxes),
                new BetterBuyerThread(cashBoxes),
                new BetterBuyerThread(cashBoxes),
                new BetterBuyerThread(cashBoxes)
        )
                .map(Thread::new)
                .peek(Thread::start)
                .collect(toList());

        for (Thread thread : threads) {
            thread.join();
        }

    }
}
