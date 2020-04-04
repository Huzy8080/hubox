package com.hubox.pattern.singleton;

/**
 * 饿汉式单例设计
 * 类加载时就实例化，线程安全。如果是重资源单例，影响启动性能。
 * 如果加载完到第一次使用之间间隔很长时间，那么就浪费资源
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/1 23:53
 */
public class SingletonHungry {

    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return instance;
    }
}
