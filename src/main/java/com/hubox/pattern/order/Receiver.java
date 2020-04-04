package com.hubox.pattern.order;

/**
 * 命令执行者
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/4 17:15
 */
public class Receiver {
    private String name;

    public Receiver(String name) {
        this.name = name;
    }

    public void doSomething() {
        System.out.println(name + ": do...!");
    }
}
