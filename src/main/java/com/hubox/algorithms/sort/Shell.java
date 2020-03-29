package com.hubox.algorithms.sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 希尔排序
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/29 11:41
 */
public class Shell extends AbstractSort {

    //
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1; // h序列: h=1,4,13,40,121,364,1093...
        }
        while (h >= 1) {//对于每个h,使用插入排序
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h /= 3;
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
