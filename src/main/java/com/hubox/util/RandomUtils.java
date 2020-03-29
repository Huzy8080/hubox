package com.hubox.util;

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

/**
 * 随机值工具类
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

    public static String[] getRandomStrArray(int length) {
        String[] a = new String[length];
        for (int i = 0; i < length; i++) {
            a[i] = randomStr(StdRandom.uniform(3, 18));
        }
        return a;
    }

    public static String randomStr(int end) {
        int length = StdRandom.uniform(2, end);
        int[] chars = new int[length];
        Alphabet alphabet = Alphabet.LOWERCASE;
        for (int i = 0; i < length; i++) {
            chars[i] = StdRandom.uniform(alphabet.radix());
        }
        return alphabet.toChars(chars);
    }
}
