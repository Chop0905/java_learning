package util;

import entity.Student;
import entity.GenderCountResult;

import java.util.List;

public class Gender {
    //工具类必须加
    private Gender() {}

    public static Student.Gender parseGender(String gender) {
        if (gender == null) return null;
        gender = gender.trim();
        if (gender.equals("男")) return Student.Gender.MALE;
        if (gender.equals("女")) return Student.Gender.FEMALE;
        return null;
    }

    public static GenderCountResult count(List<Student> students) {
        int male = 0;
        int female = 0;
        for (Student student : students) {
            if (student.getGender() == null) {
                Logger.warn("学生 " + student.getName() + " 性别为 null，已跳过");
                continue;

            }
            if (student.getGender() == Student.Gender.MALE) {
                male++;
            } else if (student.getGender() == Student.Gender.FEMALE) {
                female++;
            } else {
                Logger.warn("错误的性别" + student.getName() + "：" + student.getGender());
            }
        }
        return new GenderCountResult(male, female);
    }
}
