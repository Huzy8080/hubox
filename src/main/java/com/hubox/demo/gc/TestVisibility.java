package com.hubox.demo.gc;

public class TestVisibility {
    private static int number;
    private static boolean ready;

    public static void main(String[] args) {
        new NoVisibility().start();
        number = 44;
        ready = true;
    }

    private static class NoVisibility extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }
}
