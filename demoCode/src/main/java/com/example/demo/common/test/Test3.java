package com.example.demo.common.test;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import java.io.File;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/6/24 14:25
 */
public class Test3 {

    public int b;

    private Test11 test = new Test11(2);

    public Test3(int b) {
        this.b = b;
        System.out.println("------construct b------");
    }

    public void show() {
        b = b + test.getA();
        System.out.println("------total:" + b);
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList();
       /* a.add("11111");
        a.add("bbbbbb");
        a.add("11111");
        a.add("bbbbbbb");
        for (String b:a){
            if (b=="bbbbbb"){
                a.remove("bbbbbb");
            }
        }*/
        Map<String, String> map = new HashMap<>();
        map.put("1111","1111");
        map.put("2222","2222");
        map.put("3333","33333");
        map.put("4444","4444");

    }

}


