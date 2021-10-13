package com.company.multithreading.practice.counter_task;
/**
 * Создать класс Counter c одним полем:
 * private int count
 * методы:
 * getCount()
 * increment() - +1 к значению поля
 * decrement()
 *
 * Создать класс CounterThread с одним полем и конструктором для инициализации
 * private Counter counter;
 *
 * в методе run этого класса в цикле 100 раз вызвать counter.increment()
 *
 * в методе main создать 4 потока типа CounterThread
 * передав один и тот же объект Counter и запустить их, дождаться выполнения
 * и вывести на консоль текущее значение счетчика
 */
public class CounterDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();

        CounterThread counterThread1 = new CounterThread(counter);
        CounterThread counterThread2 = new CounterThread(counter);
        CounterThread counterThread3 = new CounterThread(counter);
        CounterThread counterThread4 = new CounterThread(counter);

        counterThread1.start();
        counterThread2.start();
        counterThread3.start();
        counterThread4.start();
        try {
            counterThread1.join();
            counterThread2.join();
            counterThread3.join();
            counterThread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount());
    }
}
