package com.hubox.pattern.decorator;

/**
 * TODO
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/4 22:16
 */
public class DecoratorClient {
    public static void main(String[] args) {
        SamDecorator component1 = new SamDecorator();
        DiffDecorator component2 = new DiffDecorator();
        component1.setComponent(component2);
        component1.show();
    }
}
