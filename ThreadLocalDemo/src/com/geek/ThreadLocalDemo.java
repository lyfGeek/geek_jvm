package com.geek;

public class ThreadLocalDemo {

    // public class ThreadLocal<T> {
    private static ThreadLocal<Long> longThreadLocal = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
//            return super.initialValue();

            System.out.println("initialValue() running");

            return Thread.currentThread().getId();// 1
        }
    };

    public static void main(String[] args) {
//        longThreadLocal.set(101L);

        new Thread() {
            @Override
            public void run() {
//                super.run();
                System.out.println(longThreadLocal.get());// 10
            }
        }.start();

        longThreadLocal.set(107L);// 如果有 set()，则 initialValue(); 不会执行。
        longThreadLocal.remove();// get(); 得到的结果为初始值 1。
        // 发现已经被 remove();，重新触发 initialValue();。——> 1
        System.out.println(longThreadLocal.get());

        // null.
    }
}
