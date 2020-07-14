package data2020714;

import java.util.Scanner;


public class PeopleManager {

    static People[] peoples = new People[10];
    private final Scanner sc = new Scanner(System.in);
    private Integer count = 0;

    public static void main(String[] args) {
        PeopleManager arrayPeopleManager = new PeopleManager();
        arrayPeopleManager.start();
    }

    void start() {
        Scanner sc = new Scanner(System.in);
        int a;
        while (true) {
            System.out.println("欢迎进入人力资源管理系统，请操作，1.查看，2.添加，3.删除，4.退出");
            a = sc.nextInt();
            if (a == 1) {
                show();
            } else if (a == 2) {
                insert();
            } else if (a == 3) {
                delete();
            } else if (a == 4) {
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
        for (var p : peoples
        ) {
            if (p != null) System.out.println(p);
        }
    }

    void insert() {
        if (count >= 9) {
            System.out.println("没有空间了，操作取消");
            return;
        }
        String name;
        int age;
        System.out.println("正在插入人员信息，请先输入姓名");
        name = sc.next();
        System.out.println("输入年龄");
        age = sc.nextInt();
        for (int i = 0; i < peoples.length; i++) {
            if (peoples[i] == null) {
                peoples[i] = new People(name, age);
                count++;
                return;
            }
        }
    }

    void delete() {
        System.out.println("请输入要删除的人员ID");
        int id = sc.nextInt();
        for (int i = 0; i < peoples.length; i++) {
            if (peoples[i].id == id) {
                peoples[i] = null;
                count--;
                return;
            }
        }
        System.out.println("未找到指定人员，删除失败");
    }


    static class People {
        static int gid;
        String name;
        int age;
        int id;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
            this.id = gid++;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", id=" + id +
                    '}';
        }
    }

}
