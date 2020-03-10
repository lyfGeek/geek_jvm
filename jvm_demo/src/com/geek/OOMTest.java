package com.geek;

import java.util.Random;

public class OOMTest {

    public static void main(String[] args) {

        String str = "geek。";

        while (true) {
            str += str + new Random().nextInt(77777777) + new Random().nextInt(999999999);
        }

//        byte[] bytes = new byte[30 * 1024 * 1024];
    }
}

// -Xms10m -Xmx10m -XX:+PrintGCDetails
