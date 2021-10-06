package com.company.file.serialization;

import com.company.entity.Student;

import java.io.*;
import java.nio.file.Path;

public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path resources = Path.of("resources", "student.out");
        writeObject(resources);
        readObject(resources);
    }

    public static void readObject(Path resources) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(resources.toFile()))) {
            Object o = objectInputStream.readObject();
            System.out.println(o);
        }
    }

    public static void writeObject(Path resources) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(resources.toFile()))) {
            Student student = new Student(10, "Pavel", "Blue");
            objectOutputStream.writeObject(student);
        }
    }
}
