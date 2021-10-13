package com.company.regular_expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String phone = "+375 (44) 771-93-92 fsdfsd +375 (44) 771-93-00" +
                       "+375 (44) 111-11-11 ggdfsfgs +375 (44) 999-99-99 dfds";
        Pattern pattern = Pattern.compile("\\+375 ?\\(\\d{2}\\) \\d{3}-\\d{2}-\\d{2}");
        Matcher matcher = pattern.matcher(phone);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuilder, "XXX");
        }
        matcher.appendTail(stringBuilder);
        System.out.println(stringBuilder);
    }

    public static void findSubString(Matcher matcher) {
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group("code"));
        }
    }
}
