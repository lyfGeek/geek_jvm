package com.geek;

public class MyObject {

    public static void main(String[] args) {

        Object object = new Object();

        System.out.println(object.getClass());
        // class java.lang.Object
        // 对象实例的模板。（Object 类）。

        System.out.println(object.getClass().getClassLoader());
        // null
        // 找那个快递员。
        // Object 祖宗，是 Bootstrap 启动类加载器加载进 Runtime Data Area。
        // Bootstrap 是 C++ 语言写的，java 得到 null。

//        System.out.println(object.getClass().getClassLoader().getParent());
        // Exception in threadDemo "main" java.lang.NullPointerException
        //	at com.geek.MyObject.main(MyObject.java:23)。——> Bootstrap 已经是祖宗了。
//        System.out.println(object.getClass().getClassLoader().getParent().getParent());
        // Exception in threadDemo "main" java.lang.NullPointerException
        //	at com.geek.MyObject.main(MyObject.java:26)

        System.out.println("~ ~ ~ ~ ~ ~ ~");

        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass());
        // class com.geek.MyObject
        System.out.println(myObject.getClass().getClassLoader());
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        // 由`启动类加载器`。AppClassLoader 加载进 Runtime Data Area。

        // rt.jar/sun/misc/Launcher.class
        //  jvm 相关调用的入口程序。

        System.out.println(myObject.getClass().getClassLoader());
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(myObject.getClass().getClassLoader().getParent());
        // sun.misc.Launcher$ExtClassLoader@74a14482
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
        // null ——> Bootstrap。

    }
}
