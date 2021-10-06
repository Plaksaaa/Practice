package com.company.date_and_time.practice.task8;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * написать свою реализацию интерфейса TemporalAdjuster
 * которая прибавляет к дате 42 дня
 */
public class Task8 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime with = now.with(temporal -> temporal.plus(42L, ChronoUnit.DAYS));
        System.out.println(with);
    }
}
