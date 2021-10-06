package com.company.date_and_time.practice.task4;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Использовать объект из прошлого задания, преобразовать в instant
 * уазав тайм зону "America/Chicago". Вывести кол-во прошедших миллисекунд
 */
public class Task4 {
    public static void main(String[] args) {
        String formattedDate = "26-03-1968T09:24";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime parse = LocalDateTime.parse(formattedDate, formatter);
        System.out.println(parse);

        Instant instant = parse.toInstant(ZoneId.of("America/Chicago").getRules().getOffset(parse));
        System.out.println(instant);
    }
}
