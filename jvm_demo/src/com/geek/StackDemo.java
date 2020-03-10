package com.geek;

public class StackDemo {

    private static void m1() throws InterruptedException {
        m1();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("111");
        m1();
        System.out.println("444");
    }
}
