package com.hubox.algorithms.sort;

import com.hubox.util.RandomUtils;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 三向切分快速排序
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/29 9:37
 */
public class Quick3Way extends AbstractSort {


    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);//不依赖于输入
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, gt = hi, i = lo + 1;
        Comparable v = a[lo];//用于比较的元素
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {//将<v的元素移动到lo指针处,lo,i均向右移动
                exchange(a, lo++, i++);
            } else if (cmp > 0) {//将>v的元素移动到hi指针处,hi向左移动
                exchange(a, hi--, i);
            } else {//等于v时,i向左移动
                i++;
            }
            //此时, a[lo...lt-1] < v = a[lt...gt] < a[gt+1...hi]
            sort(a, lo, lt - 1);
            sort(a, gt + 1, hi);
        }
    }

    public static void main(String[] args) {
        int N = 20;
        int R = 100;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = RandomUtils.uniform(R);
        }
        show(a);
        System.out.println("=====sorted=====");
        Quick.sort(a);
        assert isSorted(a);
        show(a);
    }

}
