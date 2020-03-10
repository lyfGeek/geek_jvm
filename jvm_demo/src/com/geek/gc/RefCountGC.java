package com.geek.gc;

public class RefCountGC {

    Object instance = null;
    private byte[] bigSize = new byte[2 * 1024 * 1024];// 这个成员属性的唯一作用就是占用一点内存。

    public static void main(String[] args) {
        RefCountGC objectA = new RefCountGC();
        RefCountGC objectB = new RefCountGC();
        objectA.instance = objectB;
        objectB.instance = objectA;
        objectA = null;
        objectB = null;

        System.gc();// 手动挡，手动唤起 GC。
    }
}
