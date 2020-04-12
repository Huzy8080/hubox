package com.hubox.dto;

import lombok.ToString;

/**
 * 三维元组
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/12 9:21
 */
@ToString
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }
}
