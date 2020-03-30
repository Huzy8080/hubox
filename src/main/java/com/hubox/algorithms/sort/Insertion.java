package com.hubox.algorithms.sort;

import com.hubox.util.stdlib.StdRandom;

/**
 * 插入排序
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/27 22:14
 */
public class Insertion extends AbstractSort {
    private Insertion() {
    }


    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            //移动指针i,使i的左侧总是有序!
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
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

    public static void main(String[] args) {
        int N = 20;
        int R = 100;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(R);
        }
        show(a);
        System.out.println("=====sorted=====");
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
