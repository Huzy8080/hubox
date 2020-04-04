package com.hubox.util;

/**
 * 参数校验工具类
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/3/28 23:25
 */
public class Args {

    // don't instantiate
    private Args() {
    }

    public static boolean isNull(Object x) {
        return null == x;
    }

    public static boolean notNull(Object x) {
        return !isNull(x);
    }

    // throw an IllegalArgumentException if x is null
    // (x can be of type Object[], double[], int[], ...)
    public static void validateNotNull(Object x) {
        if (isNull(x)) {
            throw new IllegalArgumentException("argument is null!");
        }
    }
}
