package com.company.multithreading.practice.account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private static int generator = 1;
    private final Lock lock = new ReentrantLock();
    private int money;
    private int id;

    public Account(int money) {
        this.money = money;
        this.id = generator++;
    }

    public void add(int money) {
        this.money += money;
    }

    public boolean takeOff(int money) {
        if (this.money >= money) {
            this.money -= money;
            return true;
        } else {
            return false;
        }
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
               "money=" + money +
               ", id=" + id +
               '}';
    }
}
