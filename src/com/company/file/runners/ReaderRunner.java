package com.company.file.runners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class ReaderRunner {
    public static void main(String[] args) throws IOException {
       /* File resources = Path.of("resources", "test.txt").toFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(resources))) {
            String collect = reader.lines()
                    .collect(joining("\n"));
            System.out.println(collect);
        }*/
//        stream нужно закрыть класс нельзя считывать неполностью
        Path path = Path.of("resources", "test.txt");

        try (Stream<String> stringStream = Files.lines(path)) {
//            readAllLines - считать все строки
            stringStream.forEach(System.out::println);
        }
    }
}
