package com.company.multithreading.practice.list_task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> arrayList = Collections.synchronizedList(new ArrayList<>());

        ListThread listThread1 = new ListThread(arrayList);
        ListThread listThread2 = new ListThread(arrayList);
        ListThread listThread3 = new ListThread(arrayList);
        ListThread listThread4 = new ListThread(arrayList);
        ListThread listThread5 = new ListThread(arrayList);
        ListThread listThread6 = new ListThread(arrayList);
        ListThread listThread7 = new ListThread(arrayList);

        listThread1.start();
        listThread2.start();
        listThread3.start();
        listThread4.start();
        listThread5.start();
        listThread6.start();
        listThread7.start();


            listThread1.join();
            listThread2.join();
            listThread3.join();
            listThread4.join();
            listThread5.join();
            listThread6.join();
            listThread7.join();

        System.out.println(arrayList);

    }
}
