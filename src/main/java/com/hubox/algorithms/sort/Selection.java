package com.hubox.algorithms.sort;

import com.hubox.util.stdlib.StdRandom;

/**
 * 选择排序
 * 特点:
 * 1.'运行时间'和'输入'无关
 * 2.数据移动最少,与数组大小N成正比
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/29 10:23
 */
public class Selection extends AbstractSort {
    //每次都选择一个最小的值X,将X移动到i的位置.当i移动到数组末尾,即全部有序
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
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
