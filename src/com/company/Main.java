package com.company;

import com.company.entity.Student;
import com.company.stream.practice.task5.Task5;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<String> strings = of("11", "22", "33", "44");
//        System.out.println(StreamExample.func(strings));

        System.out.println(Task5.getOldestName(List.of(
                new Student(22, "max", "lolchik"),
                new Student(55, "edic", "mac"),
                new Student(11, "vitaliy", "lit")
        )));

//        System.out.println(Task4.getStringFromList(of(1, 2, 3)));

    }
}
