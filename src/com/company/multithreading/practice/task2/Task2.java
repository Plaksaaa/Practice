package com.company.multithreading.practice.task2;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Задан массив случайных целых чисел
 * Найти максимальный элемент в массиве двумя способами
 * в одном потоке и используя 10 потоков
 * Сравнить затраченное время
 */
public class Task2 {

    public static void main(String[] args) {
        int[] values = new int[1_000_000];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(300) + 1;
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        trackTime(() -> findMax(values));
        trackTime(() -> {
            try {
                return findMaxParallel(values, executorService);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
            return Integer.MIN_VALUE;
        });
        executorService.shutdownNow();
    }
    private static int trackTime(Supplier<Integer> task){
        long startTime = System.currentTimeMillis();
        int max = task.get();
        System.out.println(max + ": " + (System.currentTimeMillis() - startTime));
        return max;
    }

    private static int findMax(int[] values){
        return IntStream.of(values)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    private static int findMaxParallel(int[] values, ExecutorService executorService) throws ExecutionException, InterruptedException {
        return executorService.submit(() ->IntStream.of(values)
                .parallel()
                .max()
                .orElse(Integer.MIN_VALUE)).get();
    }
}
