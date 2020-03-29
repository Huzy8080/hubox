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
public class Quick extends AbstractSort {

    private static final int M = 15;//切换阈值:小数组使用插入排序

    // don't instantiate
    private Quick() {
    }

    //========================标准切分=============================

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

    //========================三向切分=============================

    public static void sort3Way(Comparable[] a) {
        StdRandom.shuffle(a);//不依赖于输入
        sort3Way(a, 0, a.length - 1);
    }

    public static void sort3Way(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, gt = hi, i = lo + 1;
        Comparable v = a[lo];//用于比较的元素
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {//将<v的元素移动到lt指针处,lt,i均向右移动
                exchange(a, lt++, i++);
            } else if (cmp > 0) {//将>v的元素移动到gt指针处,gt向左移动
                exchange(a, i, gt--);
            } else {//等于v时,i向左移动
                i++;
            }
            //此时, a[lo...lt-1] < v = a[lt...gt] < a[gt+1...hi]
            sort3Way(a, lo, lt - 1);
            sort3Way(a, gt + 1, hi);
        }
    }

    //========================字符串三向切分快速排序=============================

    public static void sort3String(String[] a) {
        StdRandom.shuffle(a);//不依赖于输入
        sort3String(a, 0, a.length - 1, 0);
    }

    private static void sort3String(String[] a, int lo, int hi, int d) {
        //使用插入排序来排序小数组,似乎并没有改善性能
        if (hi <= lo /* + M */) {
            /*Insertion.sort(a, lo, hi, d);*/
            return;
        }
        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);//用于切分字符
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);//a[i]处的索引
            if (t < v) {//小于切分字符,放在左边
                exchange(a, lt++, i++);
            } else if (t > v) {//大于切分字符,放在右边
                exchange(a, i, gt--);
            } else {//相等,原地不动
                i++;
            }
        }
        //此时, a[lo...lt-1] < v = a[lt...gt] < a[gt+1...hi]
        sort3String(a, lo, lt - 1, d);
        if (v >= 0) {
            sort3String(a, lt, gt, d + 1);
        }
        sort3String(a, gt + 1, hi, d);
    }


    //========================测试函数=============================
    public static void main(String[] args) {
        String[] a = RandomUtils.getRandomStrArray(20);
        System.out.println("test sort:");
        sort(a);
        assert isSorted(a);
        System.out.println("test testSort3Way:");
        sort3Way(a);
        assert isSorted(a);
        System.out.println("test testSort3String:");
        sort3String(a);
        assert isSorted(a);
    }

}
