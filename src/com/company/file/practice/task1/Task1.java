package com.company.file.practice.task1;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Задан файл вывести в консоль все слова начинающиеся с гласной буквы
 */
public class Task1 {
    
    public static final String VOWELS = "уеыаоэяию";

    public static void main(String[] args) throws IOException {
        Path resources = Path.of("resources", "text.txt");
        try (Scanner scanner = new Scanner(resources)) {
            while (scanner.hasNext()){
                String word = scanner.next();
                char firstSymbol = word.charAt(0);
                if (VOWELS.indexOf(firstSymbol) != -1){
                    System.out.println(word);
                }
            }
        }
    }
}
