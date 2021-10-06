package com.company.stream.practice.task6;

import com.company.entity.Student;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * представить студентов в мапе<Возраст, Все персоны этого возраста>
 */
public class Task6 {
    public static Map<Integer, List<String>> getStudentsAgeMap(List<Student> students){
        return students.stream()
                .collect(Collectors.groupingBy(Student::getAge,
                        Collectors.mapping(Student::getFullName, Collectors.toList())));
    }
    public static Map<Integer, List<Student>> getStudentsAgeMap1(List<Student> students){
        return students.stream()
                .collect(Collectors.groupingBy(Student::getAge));
    }
}
