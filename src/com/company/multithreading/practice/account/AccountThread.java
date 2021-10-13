package com.company.multithreading.practice.account;

public class AccountThread extends Thread {
    private final Account accountTo;
    private final Account accountFrom;

    public AccountThread(Account accountTo, Account accountFrom) {
        this.accountTo = accountTo;
        this.accountFrom = accountFrom;
    }

    /*@Override
    public void run() {
        synchronized (accountFrom) {
            synchronized (accountTo) {
                for (int i = 0; i < 20; i++) {
                    if (accountFrom.takeOff(10)) {
                        accountTo.add(10);
                    }
                }
            }
        }
    }*/

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            lockAccounts();
//            если учитывать исключения так как это транзакция то нужен блок tryFl
            try {
                if (accountFrom.takeOff(10)) {
                    accountTo.add(10);
                }
            } finally {
//                отпускаю мониторы иначе при возникновении ошибок в takeOff мониторы могут не освободиться
//                Deadlock
                accountFrom.getLock().unlock();
                accountTo.getLock().unlock();
            }

        }
    }

    private void lockAccounts() {
        while (true) {
            boolean fromLockResult = accountFrom.getLock().tryLock();
            boolean toLockResult = accountTo.getLock().tryLock();
            if (fromLockResult && toLockResult) {
                break;
            }
            if (fromLockResult) {
                accountFrom.getLock().unlock();
            }
//            если получилось захватить lock то делаем unlock
            if (toLockResult) {
                accountTo.getLock().unlock();
            }
        }
    }
}
