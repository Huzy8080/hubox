package com.hubox;

/**
 * 饿汉式单例设计
 * 类加载时就实例化，线程安全。如果是重资源单例，影响启动性能。
 * 如果加载完到第一次使用之间间隔很长时间，那么就浪费资源
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/1 23:53
 */
public class Test1 {

    private static Test1 instance;

    private Integer i;
    private static Test test;

    static {
        System.out.println("static-start");
        test = new Test();
        instance = new Test1();
        System.out.println("static-end");

    }

    {
        System.out.println("nor-start");
        i = 10;
        System.out.println("nor-end");
    }

    private Test1() {
        System.out.println("私有构造器");
    }

    public static Test1 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Test1 instance = Test1.getInstance();
    }
}
