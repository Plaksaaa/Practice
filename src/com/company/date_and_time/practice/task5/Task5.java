package com.company.date_and_time.practice.task5;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Создать объект LocalDate, представляющий собой сегодняшнюю
 * дату. Создать объект LocalDate представляющий собой дату
 * 07.07.2018. Используя созданные объекты найти кол-водней между
 * двумя этими точками
 */
public class Task5 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate prevDate = LocalDate.of(2018, 7, 7);

        Period period = Period.between(prevDate, now);
        System.out.println(period.getDays());

        long between = ChronoUnit.DAYS.between(prevDate, now);
        System.out.println(between);
    }
}
