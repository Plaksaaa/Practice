package com.company.file.practice.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * в каждой строке найти и вывести наибольшее число цифр идущих подряд
 */
public class Task3 {
    public static void main(String[] args) throws IOException {
        Path resources = Path.of("resources", "test.txt");
        Files.readAllLines(resources).stream()
                .map(Task3::findMaxDigitsCount)
                .forEach(System.out::println);

    }

    private static Integer findMaxDigitsCount(String s) {
        int result = 0;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                counter++;
            } else {
                if (result < counter){
                    result = counter;
                }
                counter = 0;
            }
        }
        return result;
    }
}
