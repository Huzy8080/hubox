package com.hubox.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * 二维元组
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/12 9:21
 */
@AllArgsConstructor
@ToString
public class TwoTuple<A, B> {
    public final A first;
    public final B second;
}
