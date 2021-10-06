package com.company.date_and_time.practice.task7;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Создать объект Instant. Вывести. На основании его созздать ZoneDateTime
 * с тайм зоной Africa/Cairo
 */
public class Task7 {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);

        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Africa/Cairo"));
        System.out.println(zonedDateTime);
    }
}
