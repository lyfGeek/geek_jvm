package com.geek;

public class JVMDemo {

    public static void main(String[] args) {

        // 返回 Java 虚拟机试图使用的最大内存。
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("（-Xmx）maxMemory = " + maxMemory + "（字节）。" + (maxMemory / (double) 1024 / 1024) + " MB");

        // 返回 Java 虚拟机中的内存总量。
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println("（-Xmx）totalMemory = " + totalMemory + "（字节）。" + (totalMemory / (double) 1024 / 1024) + " MB");

        System.out.println("~ ~ ~ ~ ~ ~ ~");

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
