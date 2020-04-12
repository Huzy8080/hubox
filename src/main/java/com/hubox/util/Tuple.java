package com.hubox.util;

import com.hubox.dto.FiveTuple;
import com.hubox.dto.FourTuple;
import com.hubox.dto.ThreeTuple;
import com.hubox.dto.TwoTuple;

import java.math.BigDecimal;

/**
 * 元组工具类
 * 封装多个返回值
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/12 9:19
 */
public class Tuple {

    public static <A, B> TwoTuple<A, B> tuple(A first, B second) {
        return new TwoTuple<>(first, second);
    }

    public static <A, B, C> ThreeTuple<A, B, C> tuple(A first, B second, C third) {
        return new ThreeTuple<>(first, second, third);
    }

    public static <A, B, C, D> FourTuple<A, B, C, D> tuple(A first, B second, C third, D fourth) {
        return new FourTuple<>(first, second, third, fourth);
    }

    public static <A, B, C, D, E> FiveTuple<A, B, C, D, E> tuple(A first, B second, C third, D fourth, E fifth) {
        return new FiveTuple<>(first, second, third, fourth, fifth);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> twoTuple = tuple("1", 2);
        System.out.println(twoTuple.first);
        ThreeTuple<Object, BigDecimal, Float> tuple = tuple(new Object(), new BigDecimal(0), 1.0f);
        System.out.println(tuple.first);
    }

}
