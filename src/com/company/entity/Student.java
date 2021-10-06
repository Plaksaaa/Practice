package com.company.entity;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {

    private int age;
    private String firstName;
    private String lastName;

    public Student(int age, String name, String lastName) {
        this.age = age;
        this.firstName = name;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() &&
               Objects.equals(getFirstName(), student.getFirstName()) &&
               Objects.equals(getLastName(), student.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
               "age=" + age +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               '}';
    }
}


