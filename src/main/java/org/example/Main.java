package org.example;

import util.GenderCount;
import util.Logger;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logger.info("程序开始运行");
        Student stu = new Student("卢承福",24, Student.Gender.MALE);
        Student stu1 = new Student("卢aa",24, Student.Gender.FEMALE);
        List<Student> students = new ArrayList<>();
        students.add(stu);
        students.add(stu1);
        System.out.println("女比例："+GenderCount.count(students).getFemaleRatio());
        Logger.info("程序正常结束");
    }
}