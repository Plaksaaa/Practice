package com.company.date_and_time.practice.task6;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * посчитать кол-во секун между полуночью первой даты и полуночью второй
 */
public class Task6 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate prevDate = LocalDate.of(2018, 7, 7);

        LocalDateTime startOfDay = now.atStartOfDay();
        LocalDateTime prevStartOfDay = prevDate.atStartOfDay();

        Duration duration = Duration.between(prevStartOfDay, startOfDay);
        System.out.println(duration.getSeconds());
    }
}
