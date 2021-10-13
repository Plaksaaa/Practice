package com.company.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int incrementAndGet = atomicInteger.incrementAndGet();
        System.out.println(incrementAndGet);
    }
}
