package com.hubox.algorithms;

/**
 * 低位优先排序法
 * --> 关键点在于: "索引统计法" 保证了已排序元素的相对位置的稳定性!
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/26 23:36
 */
public class LSD {

    private LSD() {
    }

    /**
     * 通过前w个字符将a排序
     *
     * @param a 待排序数组
     * @param W 低w位
     * @return void
     * @author HUZHAOYANG
     * @date 2020/3/26 23:37
     **/
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            //统计频率
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            //将频率转换为索引
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            //将元素分类
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            //回写
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = new String[10];
        a[0] = "2IYYXMI";
        a[1] = "IXONYJF";
        a[2] = "AEFBBEF";
        a[3] = "PKE40CO";
        a[4] = "ASDFEUG";
        a[5] = "62FFICT";
        a[6] = "6322fe9";
        a[7] = "IXONYJF";
        a[8] = "OKE521F";
        a[9] = "96FEEFT";
        LSD.sort(a, 7);
        for (String s : a) {
            System.out.println(s);
        }
    }

}
