package util;

import entity.Student;

public class StudentStudy {
    private StudentStudy(Student student) {
    }

    public static void study(Student student) {
        System.out.println(student.getName() + "正在学习。");
    }
}
