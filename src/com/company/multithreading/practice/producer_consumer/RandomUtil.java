package com.company.multithreading.practice.producer_consumer;

import java.util.Random;

public final class RandomUtil {

    private static final Random RANDOM_VALUE = new Random();
    private static final int DEFAULT_BOUND = 10;

    private RandomUtil() {
    }

    public static int getRandom() {
        return RANDOM_VALUE.nextInt(DEFAULT_BOUND);
    }
}
