package com.company.stream.practice.task5;

import com.company.entity.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task5 {
    public static Optional<String> getOldestName(List<Student> students){
        return students.stream()
                .reduce((student, student2) -> student.getAge() > student2.getAge() ? student : student2)
                .filter(student -> student.getFirstName().length() + student.getLastName().length() <= 15)
                .map(student -> student.getFirstName() + " " + student.getLastName());
    }
    public static Optional<String> getOldestName1(List<Student> students){
        return students.stream()
                .filter(student -> student.getFullName().length() <= 15)
                .max(Comparator.comparing(Student::getAge))
                .map(Student::getFullName);
    }
}
