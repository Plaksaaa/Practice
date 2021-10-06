package com.company.file.practice.task2;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * в файле вывести все слова для которых последняя буква одного слова
 * совпадает с первой буквой следующего слова
 */
public class Task2 {
    public static void main(String[] args) throws IOException {
        Path resources = Path.of("resources", "test.txt");
        try (Scanner scanner = new Scanner(resources)) {
            String prev = null;
            if (scanner.hasNext()) {
                prev = scanner.next();
            }
            while (scanner.hasNext()) {
                String current = scanner.next();
                if (isEqualLastSymbolAndFirstSymbol(prev, current)) {
                    System.out.println(prev + " " + current);
                }
                prev = current;
            }
        }
    }

    private static boolean isEqualLastSymbolAndFirstSymbol(String prev, String current) {
        return prev.charAt(prev.length() - 1) == current.charAt(0);
    }
}
