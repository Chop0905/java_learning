package util;

import entity.Student;

import java.util.List;

public class StudentAverage {

    private StudentAverage() {
    }

    public static double average(List<Student> students) {
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("学生列表不能为空");
        }

        double sum = 0;
        for (Student s : students) {
            sum += s.getAge();
        }
        return sum / students.size();
    }
}
