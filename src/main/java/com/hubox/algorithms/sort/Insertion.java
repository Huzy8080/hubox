package com.hubox.algorithms.sort;

/**
 * 插入排序
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/27 22:14
 */
public class Insertion extends Sort {
    private Insertion() {
    }

    /**
     * 从第d个字符开始,对a[lo]至a[hi]进行插入排序
     *
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

}
