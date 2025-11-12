package StudentUtil;

import org.example.Student;

import java.util.List;

public class GenderCount {
    private GenderCount(){};
    public static double count(List<Student> students){
        int male = 0;
        int female = 0;
        for (Student student : students) {
            if (student.getGender().equals("male")) {
                male++;
            }else if (student.getGender().equals("female")) {
                female++;
            }else  {
                System.out.println("性别不能为："+ student.getGender());
                break;
            }
        }
        return (double) male /students.size();
    }
}
