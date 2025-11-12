package org.example;

import StudentUtil.StudentAverage;
import StudentUtil.StudentStudy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student stu1 = new Student("a",27,"male");
        Student stu2 = new Student("b",32,"male");
        Student stu3 = new Student("c",11,"male");
        Student stu4 = new Student("d",43,"male");
        List<Student> students = new ArrayList<Student>();
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);

        double average = StudentAverage.average(students);
        System.out.println(average);
    }
}