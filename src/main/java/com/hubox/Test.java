package com.hubox;

public class Test {


    private Integer i;
    private static String s;

    static {
        System.out.println("Test static-start");
        s = "hello";
        System.out.println("Test static-end");

    }

    {
        System.out.println("Test nor-start");
        i = 10;
        System.out.println("Test nor-end");

    }

    public Test() {
        System.out.println("Test 构造器");
    }


}
