package com.company.file.runners;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class OutputStreamRunner {
    public static void main(String[] args) throws IOException {
        File file = Path.of("resources", "output.txt").toFile();

        try (BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            String value = "Hello World";
            fileOutputStream.write(value.getBytes());
            fileOutputStream.write(System.lineSeparator().getBytes());
        }
    }
}
