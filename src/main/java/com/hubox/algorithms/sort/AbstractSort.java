package com.hubox.algorithms.sort;


import com.hubox.util.StdOut;

/**
 * 排序算法
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/28 22:46
 */
public abstract class AbstractSort {

    // 比较两个元素 v<w ?
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // 从第d个字符开始,比较两个字符 v<w ?
    public static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    //交换元素
    public static void exchange(Comparable[] a, int s, int t) {
        Comparable tmp = a[s];
        a[s] = a[t];
        a[t] = tmp;
    }

    //输出打印
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    //是否有序
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    //第d个字符的索引位置
    public static int charAt(String s, int d) {
        return d < s.length() ? s.charAt(d) : -1;
    }
}
