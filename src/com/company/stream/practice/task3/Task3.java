package com.company.stream.practice.task3;

import java.util.Map;

/**
 * Дана Map<String, Integer>. Найти сумму всех значений,
 *  длина ключей которых меньше 7 символов
 */
public class Task3 {
    public static int getSumFromMap(Map<String, Integer> map){
        return map.entrySet().stream()
                .filter(entry -> entry.getKey().length() < 7)
                .mapToInt(Map.Entry::getValue)
                .sum();
    }
}
