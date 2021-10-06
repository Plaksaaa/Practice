package com.company.stream.practice.task2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * В списке строк Найти кол-во уникальных строк длиной более 8 символов
 */
public class Task2 {
    public static int getUniqueString1(List<String> strings){
        return strings.stream()
                .filter(s -> s.length() > 8)
                .collect(Collectors.toSet())
                .size();
    }

    public static long getUniqueString2(List<String> strings){
        return strings.stream()
                .filter(s -> s.length() > 8)
                .distinct()
                .count();
    }
}
