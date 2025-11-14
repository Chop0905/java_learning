package service;

import entity.Student;

import java.util.ArrayList;
import java.util.List;

/*
 * 用 List 管一个“表”；实现最基本的增删改查
 * 命令行菜单与循环、输入校验；分层（service/util）
 * 任务要求 新建 service.StudentService：方法 add / deleteByName / update / list / findByName；
 * Main 里做一个简单菜单： 新增学生 2) 删除学生 3) 修改年龄/性别 4) 按名查询 5) 列表 0) 退出
 * 所有输入都要校验（空名、越界年龄、非法性别）。
 * 验收标准 启动后能循环操作；
 * 列表时附带“平均年龄 & 性别统计”。
 * */
public class StudentService {
    private final List<Student> students = new ArrayList<Student>();

    private Student.Gender parseGender(String gender) {
        if (gender == null) return null;
        gender = gender.trim();
        if (gender.equals("男")) return Student.Gender.MALE;
        if (gender.equals("女")) return Student.Gender.FEMALE;
        return null;
    }

    // 1) 新增学生
    public boolean add(String name, int age, String gender) {
        //后续添加校验

        gender = gender.trim();   //消除空格,防用户多打

        //判断名字
        if (name == null || name.trim().isEmpty()) {
            System.out.println("输入的名字有误。");
            return false;
        }

        //判断年龄
        if (age < 0 || age > 120) {
            System.out.println("年龄越界。");
            return false;
        }

        //判断性别
        Student.Gender g = parseGender(gender);
        if (g == null) {
            System.out.println("性别不合法！");
            return false;
        }
        //都校验通过后
        Student student = new Student(name, age, g);
        students.add(student);
        System.out.println("添加成功！" + student);

        return true;
    }

    // 2) 删除学生
    public boolean deleteByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("输入的名字有误。");
            return false;
        }

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getName().equals(name)) {
                students.remove(i);
                System.out.println("删除成功：" + name);
                return true;
            }
        }
        System.out.println("未查询到：" + name + " 删除失败。");
        return false;
    }

    // 3) 修改年龄/性别
    public boolean update(String name, int age, String gender) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("名字不能为空！");
            return false;
        }
        //判断年龄合法性
        if (age < 0 || age > 120) {
            System.out.println("年龄越界，修改失败。");
            return false;
        }

        //判断性别合法性
        Student.Gender g = parseGender(gender);
        if (g == null) {
            System.out.println("性别不合法，修改失败。");
            return false;
        }
        Student student_tobe_updated = null;

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getName().equals(name)) {
                student_tobe_updated = s;
                break;
            }
        }
        if (student_tobe_updated == null) {
            System.out.println("未查询到：" + name);
            return false;
        }

        student_tobe_updated.setAge(age);
        student_tobe_updated.setGender(g);
        System.out.println(name + "修改完成。");
        return true;
    }

    // 4) 按名查询
    public List<Student> getByName(String name) {
        List<Student> studentList = new ArrayList<>();
        if (name == null || name.trim().isEmpty()) {
            System.out.println("输入的名字有误。");
            return studentList;
        }
        for (Student s : students) {
            if (s.getName().contains(name)) {
                studentList.add(s);
            }
        }
        if (studentList.isEmpty()) {
            System.out.println("未查询到：" + name);
            return null;
        }
        return studentList;
    }
    // 5) 列表
    public List<Student> list() {
        return students;
    }

}
