package com.company.multithreading.practice.semaphore;

public class CashBox {

    private static int generator = 1;
    private int id;

    public CashBox() {
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "CashBox{" +
               "id=" + id +
               '}';
    }
}
