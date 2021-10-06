package com.company.stream.test;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

    public static List<Integer> func(List<String> strings) {
        return strings.stream()
                .map(value -> value + value)
                .map(Integer::valueOf)
                .filter(value -> value % 2 == 0)
                .collect(Collectors.toList());
    }

    public static void simpleFunc(List<String> strings) {
        for (String string : strings) {
            String value = string + string;
            Integer intValue = Integer.valueOf(value);
            if (intValue % 2 == 0) {
                System.out.println(intValue);
            }
        }
    }
}
