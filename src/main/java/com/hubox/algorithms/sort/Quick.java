package com.hubox.algorithms.sort;

import com.hubox.util.RandomUtils;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 快速排序
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/28 22:36
 */
public class Quick extends Sort {

    // don't instantiate
    private Quick() {
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);//不依赖于输入
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);//切分，使左子数组<=切分元素<=右子数组
        sort(a, lo, j - 1);//排序左子数组
        sort(a, j + 1, hi);//排序右子数组
    }

    /**
     * 切分函数
     * 切分步骤:
     * 1.选取a[lo]作为切分元素
     * 2.从左->右遍历元素,找到一个比a[lo]大的元素 a[left]
     * 3.从右->左遍历元素,找到一个比a[lo]小的元素 a[right]
     * 4.交换 a[left]<->a[right].
     * 5.循环1~4,直到left>=right
     * 6.此时 a[left]<=a[lo]<=a[right] ,交换a[lo]和a[right],即完成一次切分
     *
     * @author HUZHAOYANG
     * @date 2020/3/28 23:08
     **/
    private static int partition(Comparable[] a, int lo, int hi) {
        int left = lo, right = hi + 1;//定义左右指针
        Comparable v = a[lo];//切分元素
        while (true) {
            while (less(a[++left], v)) {
                if (left == hi) {
                    break;
                }
            }
            while (less(v, a[--right])) {
                if (right == lo) {
                    break;
                }
            }
            if (left >= right) {
                break;
            }
            exchange(a, left, right);
        }
        exchange(a, lo, right);
        return right;
    }

    public static void main(String[] args) {
        int N = 20;
        int R = 100;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = RandomUtils.uniform(R);
            System.out.println(a[i]);
        }
        System.out.println("=====sorted=====");
        Quick.sort(a);
        for (int i = 0; i < N; i++) {
            System.out.println(a[i]);
        }
    }
}
