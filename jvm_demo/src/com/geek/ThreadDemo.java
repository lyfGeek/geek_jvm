package com.geek;

public class ThreadDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread();

        t1.start();

        t1.start();
        // Exception in threadDemo "main" java.lang.IllegalThreadStateException
        //	at java.lang.Thread.start(Thread.java:708)
        //	at com.geek.ThreadDemo.main(ThreadDemo.java:9)
        //
        //Process finished with exit code 1
    }
}
