package com.hubox.pattern.singleton;

/**
 * 静态内部类单例
 * 利用静态内部类，在第一次使用时，才会进行初始化。而且是线程安全的
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/2 0:13
 */
public class SingletonInner {

    private SingletonInner() {
    }

    public static SingletonInner getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        private static SingletonInner instance = new SingletonInner();
    }
}
