package com.hubox.algorithms;

/**
 * 插入排序
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/27 22:14
 */
public class Insertion {
    private Insertion() {
    }

    /**
     * 从第d个字符开始,对a[lo]至a[hi]进行插入排序
     *
     * @param a
     * @param lo
     * @param hi
     * @param d
     * @return void
     * @author HUZHAOYANG
     * @date 2020/3/27 22:15
     **/
    public static void sort(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
                exchange(a, j, j - 1);
            }
        }
    }

    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    private static void exchange(String[] a, int s, int t) {
        String temp = a[s];
        a[s] = a[t];
        a[t] = temp;
    }

}
