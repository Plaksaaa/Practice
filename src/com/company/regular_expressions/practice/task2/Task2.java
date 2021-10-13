package com.company.regular_expressions.practice.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * поиск в строке 16-ричных чисел написанных по правилам java
 * вывод на страницу
 */
public class Task2 {
    public static void main(String[] args) {
        String regex = "0[Xx][0-9a-fA-F]+";
        String input = "fsdfsd 0Xff 0x23 0XAB fsdf";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
