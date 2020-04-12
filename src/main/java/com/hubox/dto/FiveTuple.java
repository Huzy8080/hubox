package com.hubox.dto;

import lombok.ToString;

/**
 * 五维元组
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/12 9:21
 */
@ToString
public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
    public final E fifth;

    public FiveTuple(A first, B second, C third, D fourth, E fifth) {
        super(first, second, third, fourth);
        this.fifth = fifth;
    }
}
