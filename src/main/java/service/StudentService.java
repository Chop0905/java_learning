package service;

import entity.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentService {
    private final List<Student> students = new ArrayList<Student>();
    // 1) 新增学生
    public boolean add(String name,int age,String gender){
        //后续添加校验

        gender=gender.trim();   //消除空格,防用户多打
        Student.Gender g = null;
        if(gender.equals("男")){
            g=Student.Gender.MALE;
        }
        else if(gender.equals("女")){
            g=Student.Gender.FEMALE;
        }else {
            System.out.println(gender+"不是一个合法的性别！");
            return false;
        }

        students.add(new Student(name,age,g));
        System.out.println("新增成功！");
        return true;
    }
}
