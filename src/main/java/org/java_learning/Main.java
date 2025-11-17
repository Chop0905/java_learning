package org.java_learning;

import dto.StudentStatisticsResult;
import service.StudentService;
import util.Helper;
import util.Logger;
import entity.Student;
import util.StudentStatistics;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger.info("程序开始运行");
        Scanner scanner = new Scanner(System.in);
        Integer option = 999;

        Helper.help();

        //创建学生对象，内有学生表
        StudentService studentService = new StudentService();

        while (true) {

            String input = scanner.nextLine();
            option = parseIntOrNull(input);

            if (option == null) {
                System.out.println("请输入数字 0~6！（输入6获取帮助）");
                System.out.println();
                continue;
            }

            String name;
            String age;
            String gender;
            //业务代码
            switch (option) {
                case 1:
                    System.out.println("请输入姓名：");
                    name = scanner.nextLine().trim();

                    System.out.println("请输入年龄：");
                    age = scanner.nextLine().trim();
                    int ageInt;
                    try {
                        ageInt = Integer.parseInt(age);
                    } catch (Exception e) {
                        System.out.println("年龄必须是数字！");
                        break;
                    }

                    System.out.println("请输入性别（男/女）：");
                    gender = scanner.nextLine().trim();

                    studentService.add(name, ageInt, gender);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;

                case 5:
                    List<Student> all = StudentService.list();
                    if (all.isEmpty()) {
                        System.out.println("当前没有学生记录。");
                        break;
                    }

                    System.out.println("===== 学生列表 =====");

                    for (Student s : all) {
                        System.out.println(s.getName() + " "
                                + s.getAge() + " "
                                + s.getGender());
                    }


                    System.out.println("----- 统计信息 -----");

                    StudentStatisticsResult result = StudentStatistics.calculate(all);
                    System.out.println("平均年龄：" + result.getAverageAge());
                    System.out.println("男生人数：" + result.getMaleCount() + "，女生人数：" + result.getFemaleCount());
                    System.out.println("男生比例：" + result.getMaleRatio() * 100 + "%");
                    System.out.println("女生比例：" + result.getFemaleRatio() * 100 + "%");
                    break;
                case 6:
                    Helper.help();
                    break;
            }
            if (option == 0) {
                break;  // 放在 switch 后面，不会触发拆箱 null 问题
            }
        }

        Logger.info("程序正常结束");
    }

    private static Integer parseIntOrNull(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return null;
        }
    }
}