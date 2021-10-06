package com.company.stream.practice.task4;

import java.util.List;
import java.util.stream.Collectors;

/**
 *  В списке целых чисел
 *  вывести строку представляющую собой
 *  конкантенацию строковых представлений этих чисел
 *  Пример: список {5, 2, 4, 2, 1}
 *  "52421"
 */
public class Task4 {
    public static String getStringFromList(List<Integer> list){
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
