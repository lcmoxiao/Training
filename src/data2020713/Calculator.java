package data2020713;

import java.util.Scanner;

public class Calculator {

    private static int add(int a, int b) {
        return a + b;
    }

    private static int sub(int a, int b) {
        return a - b;
    }

    private static int mul(int a, int b) {
        return a * b;
    }

    private static double div(int a, int b) {
        return (double) a / b + mod(a, b);
    }

    private static int mod(int a, int b) {
        return a % b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choiceId, a, b;
        System.out.println("1.加法，2.减法，3.乘法，4.除法，5.整除,6.退出");
        while (true) {
            choiceId = sc.nextInt();
            if (choiceId == 6) return;
            System.out.println("请依次输入要参与运算的两个数字");
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println("输入成功，正在计算，结果是:");
            switch (choiceId) {
                case 1 -> System.out.println(add(a, b));
                case 2 -> System.out.println(sub(a, b));
                case 3 -> System.out.println(mul(a, b));
                case 4 -> System.out.println(div(a, b));
                case 5 -> System.out.println(mod(a, b));
                default -> {
                    throw new IllegalStateException("Unexpected value: " + choiceId);
                }
            }
            System.out.println("1.加法，2.减法，3.乘法，4.除法，5.整除,6.退出");
        }
    }
}
