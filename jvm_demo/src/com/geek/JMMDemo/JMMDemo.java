package com.geek.JMMDemo;


class MyNumber {
    volatile int number = 10;

    public void addto1024() {
        this.number = 1024;
    }
}

/**
 * JMM ——> 可见性（通知机制）。
 */
public class JMMDemo {

    public static void main(String[] args) {

        MyNumber myNumber = new MyNumber();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "~ ~ ~ comes in.");
            // 暂停一会儿线程。
            try {
                Thread.sleep(3000);

                myNumber.addto1024();// 将 10 修改为 1024。
                System.out.println(Thread.currentThread().getName() + "\tupdate number, number value: " + myNumber.number);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        // 产生共享变量 number = 10。

        // main 线程直接运行至此。
        while (myNumber.number == 10) {

            // 需要有一种机制告诉 main 线程，number 已经修改为 1024,跳出 while。
//            volatile int number = 10;
        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}


/*

A~ ~ ~ comes in.
A	update number, number value: 1024

Process finished with exit code 130 (interrupted by signal 2: SIGINT)

// 此时程序永不会结束。
// A 线程已经把 number 值改为 1024。（A	update number, number value: 1024）
// 但 main 线程并不知道。
 */
