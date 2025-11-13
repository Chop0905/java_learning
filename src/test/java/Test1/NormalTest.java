package Test1;

import entity.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class NormalTest {
    @Test
    void testUnNormal() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student("minus 1",-1, Student.Gender.MALE);
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new Student("over 120",121,Student.Gender.MALE);
        });
    }

}
