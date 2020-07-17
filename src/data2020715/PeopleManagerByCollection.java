package data2020715;

import java.util.ArrayList;
import java.util.Scanner;


public class PeopleManagerByCollection {

    static ArrayList<People> peoples = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PeopleManagerByCollection arrayPeopleManager = new PeopleManagerByCollection();
        arrayPeopleManager.start();
    }

    void start() {
        int a;
        while (true) {
            System.out.println("欢迎进入人力资源管理系统，请操作，1.查看，2.添加，3.删除，4.查找,5.退出");
            System.out.println("——————————————————————————————");
            a = sc.nextInt();
            if (a == 1) {
                show();
            } else if (a == 2) {
                String name;
                int age;
                System.out.println("正在插入人员信息，请先输入姓名");
                name = sc.next();
                System.out.println("输入年龄");
                age = sc.nextInt();
                System.out.println("插入结果为" + insert(name, age));
                System.out.println("——————————————————————————————");
            } else if (a == 3) {
                System.out.println("请输入要删除的人员ID");
                int id = sc.nextInt();
                System.out.println("删除结果为" + delete(id));
                System.out.println("——————————————————————————————");
            } else if (a == 4) {
                System.out.println("请输入要查找的人员ID");
                int id = sc.nextInt();
                System.out.println("查找结果为" + find(id));
                System.out.println("——————————————————————————————");
            } else if (a == 5) {
                System.out.println("退出");
                System.out.println("——————————————————————————————");
                return;
            } else {
                System.out.println("无效输入");
                System.out.println("——————————————————————————————");
            }
        }
    }

    /**
     * 根据给定的姓名和年龄生成员工信息并保存
     *
     * @param name 员工姓名
     * @param age  员工年龄
     * @return 信息添加成功返回true，负责false
     */
    boolean insert(String name, int age) {
        People p = new People(name, age);
        //添加指定信息的人员到peoples里
        return peoples.add(p);
    }

    /**
     * 展示所有员工的信息
     */
    void show() {
        if (peoples.size() == 0) {
            System.out.println("暂无人员信息");
        } else {
            //直接显示所有人的信息
            peoples.forEach(System.out::println);
        }
    }

    /**
     * 删除给定id的员工的信息
     *
     * @param id 员工id
     * @return 信息添加成功返回true，负责false
     */
    boolean delete(int id) {
        //删除指定id的人员
        for (var p : peoples) {
            if (p.getId() == id) {
                peoples.remove(p);
                return true;
            }
        }
        System.out.println("未找到指定人员，删除失败");
        return false;
    }

    /**
     * 查找给定id的员工的信息
     *
     * @param id 员工id
     * @return 信息添加成功返回true，负责false
     */
    boolean find(int id) {
        //删除指定id的人员
        for (var p : peoples)
            if (p.getId() == id) {
                System.out.println(p);
                return true;
            }
        System.out.println("未找到指定人员");
        return false;
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
        return "员工ID：" + id + " 姓名：" + name + " 年龄：" + age;
    }
}
