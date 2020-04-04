package com.hubox.pattern.singleton;

/**
 * 双重检查锁
 * 既延迟加载，又不用承担每次获取实例时的加锁性能损失。
 * volatile 非常关键，保证了DCL的线程安全性
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/2 0:08
 */
public class SingletonDCL {
    //volatile非常关键，保证初始化时的线程安全性
    private static volatile SingletonDCL instance;

    private SingletonDCL() {

    }

    public static SingletonDCL getInstance() {
        if (null == instance) {
            synchronized (SingletonDCL.class) {
                if (null == instance) {
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}
