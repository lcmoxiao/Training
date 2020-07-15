package data2020715;

import java.util.ArrayList;
import java.util.Scanner;


public class PeopleManagerByList {

    static ArrayList<People> peoples = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PeopleManagerByList arrayPeopleManager = new PeopleManagerByList();
        arrayPeopleManager.start();
    }

    void start() {
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

    //展示所有人的信息
    void show() {
        if (peoples.size() != 0) {
            System.out.println("信息为空");
            return;
        }
        //直接显示所有人的信息
        System.out.println(peoples);
    }

    //插入员工信息
    void insert() {
        String name;
        int age;
        System.out.println("正在插入人员信息，请先输入姓名");
        name = sc.next();
        System.out.println("输入年龄");
        age = sc.nextInt();
        //添加指定信息的人员
        peoples.add(new People(name, age));
    }

    //删除员工信息
    void delete() {
        System.out.println("请输入要删除的人员ID");
        int id = sc.nextInt();
        //删除指定id的人员
        peoples.removeIf(p -> p.getId() == id);
        System.out.println("未找到指定人员，删除失败");
    }

    //查找员工信息
    void find() {
        System.out.println("请输入要查找的人员ID");
        int id = sc.nextInt();
        //删除指定id的人员
        for (var p : peoples)
            if (p.getId() == id) {
                System.out.println(p);
                return;
            }
        System.out.println("未找到指定人员，删除失败");
    }
}

class People {
    static int gid;
    private String name;
    private int age;
    private int id;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = gid++;
    }

    public static int getGid() {
        return gid;
    }

    public static void setGid(int gid) {
        People.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
