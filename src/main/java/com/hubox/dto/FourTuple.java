package com.hubox.dto;

import lombok.ToString;

/**
 * 四维元组
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/12 9:21
 */
@ToString
public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D fourth;

    public FourTuple(A first, B second, C third, D fourth) {
        super(first, second, third);
        this.fourth = fourth;
    }
}
