package com.example.demo2.test;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import java.util.Scanner;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/8/13 19:48
 */
public class Test1 {


    public static int[] getArray(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aStart = 0;
        int bEnd = b.length - 1;
        for (int i = 0; i < result.length; i++) {
            if (aStart > a.length - 1) {
                result[i] = a[aStart];
                aStart = aStart++;
                continue;
            }
            if (bEnd < 0) {
                result[i] = b[bEnd];
                bEnd = bEnd--;
                continue;
            }

            if (a[aStart] > b[bEnd]) {
                result[i] = a[aStart];
                aStart = aStart++;
            } else {
                result[i] = b[bEnd];
                bEnd = bEnd--;

            }
        }

        return result;
    }

}
