package org.example;

import StudentUtil.GenderCount;
import StudentUtil.StudentAverage;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student stu = new Student("卢承福",24, Student.Gender.MALE);
        System.out.println(stu.getClass());
    }
}