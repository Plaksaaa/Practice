package com.company.regular_expressions.practice.task1;

import java.util.regex.Pattern;

/**
 * Является ли введеная строка с адресом почтового ящика
 */
public class Task1 {

    public static void main(String[] args) {
        String regex = "[a-zA-Z]\\w+@\\w{3,}\\.(org|com)";

        String s = "lol@mail.com";
        System.out.println(Pattern.matches(regex, s));
    }
}
