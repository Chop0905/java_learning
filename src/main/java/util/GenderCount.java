package util;

import entity.Student;
import entity.GenderCountResult;
import java.util.List;

public class GenderCount {
    //工具类必须加
    private GenderCount(){}

    public static GenderCountResult count(List<Student> students){
        int male = 0;
        int female = 0;
        for (Student student : students) {
            if (student.getGender() == Student.Gender.MALE) {
                male++;
            }else if (student.getGender() == Student.Gender.FEMALE) {
                female++;
            }
        }

        return new GenderCountResult(male,female);
    }
}
