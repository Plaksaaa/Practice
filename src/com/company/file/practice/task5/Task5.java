package com.company.file.practice.task5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

/**
 * задан файл с java кодом
 * записать в другой файл этот код наоборот
 */
public class Task5 {
    public static void main(String[] args) {
        Path path = Path.of("src", "com", "company", "file", "practice", "task4", "Task4.java");
        Path resources = Path.of("resources", "Task4.java");

        try (Stream<String> lines = Files.lines(path);
             BufferedWriter writer = Files.newBufferedWriter(resources, APPEND, CREATE)) {

            lines.map(StringBuilder::new)
                    .map(StringBuilder::reverse)
                    .forEach(line -> {
                        try {
                            writer.write(line.toString());
                            writer.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
