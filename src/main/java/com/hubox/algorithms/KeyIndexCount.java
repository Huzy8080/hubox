package com.hubox.algorithms;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 键索引计数法
 * 适用于小整数键的排序法。
 * TIPS:排序N个键为[0,R-1)的整数的元素,需要访问数组 11N+4R+1 次.
 * 该排序法突破了 NlogN 排序(基于比较)算法的下限!
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/26 21:43
 */
public class KeyIndexCount {

    public void sort(Staff[] a, int R) {
        int N = a.length;
        Staff[] aux = new Staff[N];//临时数组
        int[] count = new int[R + 1];//R+1是为了容纳最后一组的索引位置,不让数组溢出
        //统计索引出现的频率
        for (int i = 0; i < N; i++) {
            count[a[i].getKey() + 1]++;
        }
        //将频率转换为索引(aux数组的索引位置)
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }
        //将元素写到临时数组中.count[i]++的作用是保证下一个key为i的元素在正确的aux索引位置
        for (int i = 0; i < N; i++) {
            aux[count[a[i].getKey()]++] = a[i];
        }
        //回写到原数组中
        for (int i = 0; i < N; i++) {
            a[i] = aux[i];
        }
    }

    public static void main(String[] args) {
        KeyIndexCount keyIndexCount = new KeyIndexCount();
        Staff[] a = keyIndexCount.initStaff(5);
        for (Staff staff : a) {
            System.out.println(staff);
        }
        keyIndexCount.sort(a, 5);
        System.out.println("=====sort=====");
        for (Staff staff : a) {
            System.out.println(staff);
        }
    }

    //key in [0,R-1)
    public Staff[] initStaff(int R) {
        Staff[] a = new Staff[10];
        a[0] = new Staff("White", 1);
        a[1] = new Staff("Anderson", 2);
        a[2] = new Staff("Brown", 3);
        a[3] = new Staff("Davis", 3);
        a[4] = new Staff("Garcia", 4);
        a[5] = new Staff("Harris", 1);
        a[6] = new Staff("Jackson", 4);
        a[7] = new Staff("Jones", 2);
        a[8] = new Staff("Moore", 3);
        a[9] = new Staff("Thomas", 4);
        return a;
    }

    @Data
    @AllArgsConstructor
    class Staff {
        private String name;//姓名
        private int key;//所处组号

        @Override
        public String toString() {
            return name + " " + key;
        }
    }

}
