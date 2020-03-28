package com.hubox.algorithms.sort;

/**
 * 高位优先排序
 * TIPS:对于较大的字母表,会产生陷阱:
 * 1.每个字符串都会产生一个只含有它自己的小数组,每一次排序都会初始化R大小的count[]数组,代价非常高.
 * 可以在数组size小于某个值时,使用插入排序
 * 2.大量键值相等的情况,无法切换到插入排序
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/27 20:28
 */
public class MSD {
    private MSD() {
    }

    private static final int R = 256;//字母表基数
    private static final int M = 20;//小数组的切换阈值.当要排序的数组size<=M时,切换为插入排序
    private static String[] aux;//辅助数组.

    /**
     * 判断第d个字符是否为结尾字符
     *
     * @param s
     * @param d
     * @return int
     * @author HUZHAOYANG
     * @date 2020/3/27 20:57
     **/
    private static int charAt(String s, int d) {
        return d < s.length() ? s.charAt(d) : -1;
    }

    private static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    /**
     * 排序
     *
     * @param a  待排序数组
     * @param lo 子数组的起始索引位置
     * @param hi 子数组的结束索引位置
     * @param d  以第几个字符为KEY来统计索引
     * @return void
     * @author HUZHAOYANG
     * @date 2020/3/27 21:02
     **/
    public static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
            Insertion.sort(a, lo, hi, d);
            return;
        }
        //开始使用索引计数法排序
        int[] count = new int[R + 2];
        //统计频率
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }
        //转换为索引
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }
        //数据分类
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        //回写数据
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }
        //递归调用,排序子数组.
        // 因为每次排序一个字母,假设为H,以H开关的子数组数量为x,那么这个增量x
        // 已经在'频率转索引'那一步转换为了count[charAt(H)+]的起始索引,count[charAt(I)]的值也已经通过数据分类,将索引.
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    public static void main(String[] args) {
        String[] a = new String[6];
        a[0] = "dush";
        a[1] = "are";
        a[2] = "by";
        a[3] = "duck";
        a[4] = "dubbo";
        a[5] = "bye";
        sort(a);
        for (String s : a) {
            System.out.println(s);
        }
    }

}
