package com.hubox.demo.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试对象分配
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/25 11:48
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        keepJVMAlive();
//        testAllocation();
//        testPretenureSizeThreshold();
//        fillHeap(1000);

    }

    /**
     * 对象优先分配在Eden
     * 测试新生代Mirror GC 使用SerialGC收集器
     * vm参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     **/
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];//出现一次mirror gc
    }

    /**
     * 大对象直接进入老年代
     * 使用SerialGC收集器
     * vm参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728
     **/
    public static void testPretenureSizeThreshold() {
        byte[] allocation = new byte[4 * _1MB];
    }

    /**
     * 长期存活的对象进入老年代
     * 使用SerialGC收集器
     * vm参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:+UseSerialGC -XX:MaxTenuringThreshold=1 -XX:PrintTenuringDistribution
     **/
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    public static void keepJVMAlive() throws InterruptedException {
        byte[] allocation1, allocation2;
        while (true) {
            allocation1 = new byte[2 * _1MB];
            allocation1 = null;
            Thread.sleep(1000L);
            allocation2 = new byte[4 * _1MB];
            allocation2 = null;
        }
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(100);
            list.add(new OOMObject());
        }
        System.gc();
    }

    static class OOMObject {
        public byte[] placeHolder = new byte[64 * 1024];
    }

}
