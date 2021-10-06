package com.company.file.runners;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class InputStreamRunner {
    public static void main(String[] args) throws IOException {
        File file = Path.of("recources", "test.txt").toFile();
        try (BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(file))) {
            byte[] bytes = fileInputStream.readAllBytes();
            String s = new String(bytes);
            System.out.println(s);

//            побайтовое чтение
           /* byte[] bytes = new byte[fileInputStream.available()];
            int counter = 0;
            byte currentByte;
            while ((currentByte = (byte) fileInputStream.read())!= -1) {
                bytes[counter++] = currentByte;
            }
            String s = new String(bytes);
            System.out.println(s);*/
        }
    }
}
