package com.hubox.pattern.singleton;

/**
 * 懒汉式单例
 * 第一次使用时，才会进行初始化，好处在于节约资源。
 * 缺点在于，每次访问都要进行加锁。如果访问不频率，或者加锁的性能损失
 * 不是很关键，那么可以选择使用这种方式。
 * 注意：这种是线程安全的单例。
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/2 0:01
 */
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {
    }

    private static synchronized SingletonLazy getInstance() {
        if (null == instance) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
