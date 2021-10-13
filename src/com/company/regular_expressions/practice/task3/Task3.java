package com.company.regular_expressions.practice.task3;

/**
 * поиск в строке всех тегов абзацев с параметрами и замена их на простые
 */
public class Task3 {
    public static void main(String[] args) {
        String regex = "(<p .+?>)(.+?</p>)";
        String input = "<p> asadfadfa afas </p> <b> asdas </b> sfds <p id=\"p1\">dasda asd </p>" +
                       "ddfa <p> dafad";
        System.out.println(input.replaceAll(regex, "<p>$2"));
    }
}
