package com.company.stream.practice.task1;

import java.util.List;
import java.util.OptionalDouble;

/**
 * Дан список чисел. Найти среднее всех нечетных чисел делящихся на 5
 */
public class Task1 {
    public static OptionalDouble getAverage(List<Integer> list){
        return list.stream()
                .filter(integer -> (integer % 2 != 0) && (integer % 5 == 0))
                .mapToInt(Integer::intValue)
                .average();
//        average.ifPresent(System.out::println);
    }
}
