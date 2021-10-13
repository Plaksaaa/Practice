package com.company.multithreading.practice.task1;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Написать программу бесконечно считывающую
 * пользовательские данные с консоли
 * Числа прдеставляют собой кол-во секунд
 * При каждом вводе числа должна создаваться задача
 * которая засыпает на введеное кол-во секунд и затем
 * выводит я спал n секунд
 * Нужно стделать так чтобы все задачи выполнялись в одном потоке в порядке ввода
 * Т.e. в программе есть два потока главный и поток для выполнения всех задач по очереди
 * При вводе отрицательного числа программа должна останавливаться
 * Второе решение - несколько потоков в пуле. Посчитаьт кол-во обработанных задач каждым потоком
 */
public class Task1 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Scanner scanner = new Scanner(System.in);
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        while (scanner.hasNextInt()) {
            int seconds = scanner.nextInt();

            if (seconds < 0) {
                break;
            }
            executorService.submit(() -> {
                Integer counter = threadLocal.get();
                threadLocal.set(counter == null ? 1 : counter);
                System.out.println(String.format("Поток %s задач %d ", Thread.currentThread().getName(), threadLocal.get() ));
                Thread.sleep(seconds * 1000);
                System.out.println(String.format("Поток %s спал %d ", Thread.currentThread().getName(), seconds));
                return seconds;
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1L, TimeUnit.HOURS);
    }
}
