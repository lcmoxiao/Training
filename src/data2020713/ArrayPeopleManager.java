package data2020713;

import java.util.ArrayList;
import java.util.Scanner;


public class ArrayPeopleManager {

    private static int gid = 0;
    private final Scanner sc = new Scanner(System.in);
    private final int size = 10;
    Integer[] ids = new Integer[size];
    String[] names = new String[size];
    Integer[] ages = new Integer[size];
    private Integer count = 0;

    public static void main(String[] args) {
        ArrayPeopleManager arrayPeopleManager = new ArrayPeopleManager();
        arrayPeopleManager.start();
    }

    void start() {
        while (true) {
            System.out.println("欢迎进入人力资源管理系统，请操作，1.查看，2.添加，3.删除，4.退出");
            int inNub = sc.nextInt();
            if (inNub == 1) {
                show();
            } else if (inNub == 2) {
                insert();
            } else if (inNub == 3) {
                delete();
            } else if (inNub == 4) {
                System.out.println("退出");
                return;
            } else {
                System.out.println("无效输入");
            }
        }
    }

    void show() {
        if (count == 0) {
            System.out.println("信息为空");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (ids[i] != null) {
                System.out.println(ids[i] + names[i] + ages[i]);
            }
        }
    }

    void insert() {
        if (count == size - 1) {
            System.out.println("没有空间了，操作取消");
            return;
        }
        String name;
        int age;
        System.out.println("正在插入人员信息，请先输入姓名");
        name = sc.next();
        System.out.println("输入年龄");
        age = sc.nextInt();
        for (int i = 0; i < size; i++) {
            if (ids[i] == null) {
                ids[i] = gid++;
                names[i] = name;
                ages[i] = age;
                count++;
                return;
            }
        }
    }

    void delete() {
        System.out.println("请输入要删除的人员ID");
        int id = sc.nextInt();
        for (int i = 0; i < size; i++) {
            if (ids[i] == id) {
                ids[i] = null;
                names[i] = null;
                ages[i] = null;
                count--;
                return;
            }
        }
        System.out.println("未找到指定人员，删除失败");
    }


}
