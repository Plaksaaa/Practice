package com.company.multithreading.pool;

import java.util.Optional;
import java.util.Queue;

public class PoolThread extends Thread {
    //очередь задач
    private final Queue<Runnable> tasks;

    public PoolThread(Queue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            Optional<Runnable> task = Optional.empty();
            synchronized (tasks) {
                if (!tasks.isEmpty()) {
//                    забираем задачу
                    task = Optional.of(tasks.remove());
                }
            }
//            если задача существует выполняем её
            task.ifPresent(Runnable::run);
        }
    }
}
