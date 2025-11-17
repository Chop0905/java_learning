package util;

import dto.StudentStatisticsResult;
import entity.Student;

import java.util.List;

public class StudentStatistics {

    private StudentStatistics() {}

    public static StudentStatisticsResult calculate(List<Student> students) {
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("学生列表不能为空");
        }

        int male = 0;
        int female = 0;
        int totalAge = 0;

        for (Student s : students) {
            totalAge += s.getAge();

            if (s.getGender() == Student.Gender.MALE) {
                male++;
            } else if (s.getGender() == Student.Gender.FEMALE) {
                female++;
            }
        }

        int total = male + female;

        double maleRatio = total == 0 ? 0 : (double) male / total;
        double femaleRatio = total == 0 ? 0 : (double) female / total;
        double avgAge = total == 0 ? 0 : (double) totalAge / total;

        return new StudentStatisticsResult(
                male,
                female,
                total,
                maleRatio,
                femaleRatio,
                avgAge
        );
    }
}
