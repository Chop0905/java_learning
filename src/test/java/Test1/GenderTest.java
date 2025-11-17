package Test1;

import entity.GenderCountResult;
import entity.Student;
import org.junit.jupiter.api.Test;
import util.Gender;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenderTest {

    @Test
    void testGender() {
        Student stu = new Student("a",24, Student.Gender.MALE);
        Student stu1 = new Student("b",19, Student.Gender.FEMALE);
        Student stu2 = new Student("c",26, Student.Gender.MALE);
        Student stu3 = new Student("d",29, Student.Gender.FEMALE);
        Student stu4 = new Student("e",31, Student.Gender.MALE);
        Student stu5 = new Student("f",40, Student.Gender.FEMALE);

        //构建集合
        List<Student> students = new ArrayList<>();
        students.add(stu);
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);
        students.add(stu5);

        GenderCountResult result = Gender.count(students);
        assertEquals(3, result.getFemaleCount());
        assertEquals(3, result.getMaleCount());
        assertEquals(0.5, result.getFemaleRatio(), 0.0001);
        assertEquals(0.5, result.getMaleRatio(), 0.0001);
    }
}
