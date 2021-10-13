package com.company.multithreading.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(3);

        ScheduledFuture<?> scheduledFuture = threadPool.schedule(() -> System.out.println("OK!"), 2L, TimeUnit.SECONDS);

        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.HOURS);
//        создает пул из одного потока
//        Executors.newSingleThreadExecutor();

//        столько потоков сколько передали
//        InitializeFixedPool();

//        завершает все потоки и возвращает задачи которые не успели выполниться
//        threadPool.shutdownNow();

//        безграничный - постоянно создает потоки
//        Executors.newCachedThreadPool();

//        можем выполнять задачи с задержкой(например обновление информации или сбор мусора)
//        Executors.newScheduledThreadPool(3);

//        создает пул такого размера насколько позволяет процессор, на основании реализации ForkJoinPool
//        Executors.newWorkStealingPool();
    }

    public static void InitializeFixedPool() throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(2000L);
            System.out.println("its callable");
            return 1;
        });


        System.out.println("Result: " + future.get());

//        ждет вывполнения всех потоков
        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.HOURS);
        System.out.println("main end");
    }
}
