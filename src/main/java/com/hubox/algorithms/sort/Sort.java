package com.hubox.algorithms.sort;

/**
 * 排序算法
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/28 22:46
 */
public class Sort {


    /**
     * 比较两个元素大小
     *
     * @author HUZHAOYANG
     * @date 2020/3/28 22:52
     **/
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 从第d个字符开始,比较两个字符大小
     *
     * @return boolean
     * @author HUZHAOYANG
     * @date 2020/3/28 22:48
     **/
    public static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    /**
     * 交换元素
     *
     * @author HUZHAOYANG
     * @date 2020/3/28 22:48
     **/
    public static void exchange(Comparable[] a, int s, int t) {
        Comparable temp = a[s];
        a[s] = a[t];
        a[t] = temp;
    }
}
