package data2020713;

import java.util.Scanner;

public class FingerGuessing {

    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请出拳，1.剪刀，2.石头，3.布，4.退出");
            a = sc.nextInt();
            b = (int) (Math.random() * 3) + 1;
            if (a == 1) {
                if (b == 1) System.out.println("平局");
                else if (b == 2) System.out.println("你输了");
                else if (b == 3) System.out.println("你赢了");
            } else if (a == 2) {
                if (b == 2) System.out.println("平局");
                else if (b == 3) System.out.println("你输了");
                else if (b == 1) System.out.println("你赢了");
            } else if (a == 3) {
                if (b == 3) System.out.println("平局");
                else if (b == 1) System.out.println("你输了");
                else if (b == 2) System.out.println("你赢了");
            } else if (a == 4) {
                System.out.println("退出游戏");
                return;
            } else {
                System.out.println("无效输入");
            }
        }
    }
}
