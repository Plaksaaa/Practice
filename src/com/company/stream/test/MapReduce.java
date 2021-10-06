package com.company.stream.test;

import com.company.entity.Student;

import java.util.Optional;
import java.util.stream.Stream;

public class MapReduce {
    public static void mapR(){
        Optional<Student> optionalStudent = Stream.of(
                new Student(22, "vic", "fdf"),
                new Student(25, "loh", "dsaf"),
                new Student(40, "vit", "fdds")
        )
//                .sequential()
                .parallel()
//                .map(Student::getAge)
//                .reduce(Math::max) возвращали только значение int а с opt возвращаем
                .reduce((student1, student2) -> student1.getAge() > student2.getAge() ? student1 : student2);

    }
}
