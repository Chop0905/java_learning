package Test1;

import entity.Student;
import util.StudentAverage;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StudentUtilTest {

    @Test
    void testAvgAge() {
        List<Student> list = Arrays.asList(
                new Student("张三", 20, Student.Gender.MALE),
                new Student("李四", 30, Student.Gender.MALE)
        );

        double avg = StudentAverage.average(list);

        assertEquals(25.0, avg, 0.0001);
    }
}
