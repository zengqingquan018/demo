package com.example.demo.common.test;


import java.io.Serializable;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/7/3 16:54
 */
public class Test11 {

    int a;

    public Test11(int a) {
        this.a = a;
        System.out.println("------construct a------");
    }

    public int getA() {
        return a;
    }

}
