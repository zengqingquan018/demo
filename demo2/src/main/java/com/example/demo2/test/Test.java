package com.example.demo2.test;

import java.util.Scanner;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/8/7 15:45
 */
public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        String[] param = value.split(",");
        int len = Integer.valueOf(param[0]);
        int m = Integer.valueOf(param[1]);
        int n = Integer.valueOf(param[2]);
        int days = climb(len, m, n);
        System.out.println(days);
    }

    public static int climb(int len, int m, int n) {
        int days = 0;
        do {
            len = len - m;
            days = days + 1;
            if (len <= 0) {
                return days;
            }
            len = len + n;
        } while (len > 0);

        return days;
    }

}
