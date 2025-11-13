package org.java_learning;

import util.GenderCount;
import util.Logger;
import entity.Student;
import util.StudentAverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger.info("程序开始运行");
        Scanner scanner = new Scanner(System.in);
        Integer option=999;
        while (true){
            System.out.println("1) 新增学生");
            System.out.println("2) 删除学生");
            System.out.println("3) 修改年龄/性别");
            System.out.println("4) 按名查询");
            System.out.println("5) 列表");
            System.out.println("0) 退出");
            System.out.print("请选择：");

            String input = scanner.nextLine();
            option = parseIntOrNull(input);

            if (option == null) {
                System.out.println("请输入数字 0~5！");
                System.out.println();
                continue;
            }

            //业务代码

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