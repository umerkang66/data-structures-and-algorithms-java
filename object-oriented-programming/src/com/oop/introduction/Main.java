package com.oop.introduction;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(12, "umer", 80);
        }
        System.out.println(Arrays.toString(Arrays.toString(students).toCharArray()));
    }
}

class Student {
    public int rollNumber;
    public String name;
    public double marks;

    public Student(int rollNumber, String name, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
    }
}
