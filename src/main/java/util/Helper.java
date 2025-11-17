package util;

public class Helper {
    private  Helper() {}
    public static void help(){
        System.out.println("1) 新增学生");
        System.out.println("2) 删除学生");
        System.out.println("3) 修改年龄/性别");
        System.out.println("4) 按名查询");
        System.out.println("5) 列表");
        System.out.println("6) 帮助");
        System.out.println("0) 退出");
        System.out.print("请选择：");
    }
}
