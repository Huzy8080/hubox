package com.hubox.util;

import java.util.Random;

/**
 * 随机值工具类
 * 参考《算法》的源码实现
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/28 23:03
 */
public class RandomUtils {

    private static Random random;    // pseudo-random number generator
    private static long seed;        // pseudo-random number generator seed

    // static initializer
    static {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    // don't instantiate
    private RandomUtils() {
    }

    /**
     * 生成一个[0,n)的整数
     *
     * @param n 上界(不包含)
     * @return int
     * @author HUZHAOYANG
     * @date 2020/3/28 23:05
     **/
    public static int uniform(int n) {
        if (n <= 0) throw new IllegalArgumentException("argument must be positive: " + n);
        return random.nextInt(n);
    }

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param a the array to shuffle
     * @throws IllegalArgumentException if {@code a} is {@code null}
     */
    public static void shuffle(Object[] a) {
        Args.validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);     // between i and n-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
