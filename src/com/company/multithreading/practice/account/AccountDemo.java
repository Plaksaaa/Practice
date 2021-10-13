package com.company.multithreading.practice.account;

public class AccountDemo {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(20000);
        Account account1 = new Account(20000);

        AccountThread accountThread = new AccountThread(account, account1);
        AccountThread accountThread1 = new AccountThread(account1, account);

        accountThread.start();
        accountThread1.start();

        accountThread.join();
        accountThread1.join();
        System.out.println(account);
        System.out.println(account1);
    }
}
