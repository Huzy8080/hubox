package com.hubox.demo.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁的应用
 *
 * @author HUZHAOYANG
 * @version 1.0
 * @date 2020/4/13 22:17
 */
public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        //开始门，所有线程准备完毕后才执行主线程
        final CountDownLatch startGate = new CountDownLatch(1);
        //结束门，所有线程执行完毕后继续执行主线程
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException, ignore!");
                }
            });
            t.start();
        }
        long startTime = System.currentTimeMillis();
        startGate.countDown();//所有线程开始执行
        endGate.await();//等待所有线程执行完毕
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
