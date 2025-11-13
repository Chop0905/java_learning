package org.example;

import StudentUtil.GenderCount;
import StudentUtil.StudentAverage;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student stu = new Student("a",27, Student.Gender.MALE);

        System.out.println(stu.toString());
    }
}