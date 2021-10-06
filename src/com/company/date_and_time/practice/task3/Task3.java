package com.company.date_and_time.practice.task3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * дана строка вида "26-03-1968Т09:24". Получить объект LocalDateTime
 * представлющий собой дату, полученную из этой строки
 */
public class Task3 {
    public static void main(String[] args) {
        String formattedDate = "26-03-1968T09:24";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime parse = LocalDateTime.parse(formattedDate, formatter);
        System.out.println(parse);
    }
}
