package com.geek;


class CodeGeek {
    static {
        System.out.println("code 的静态代码块 333。");
    }

    {
        System.out.println("code 的构造方法 222。");
    }

    public CodeGeek() {
        System.out.println("code 的构造方法 111。");
    }
}


public class CodeBlockDemo {

    static {
        System.out.println("CodeBlockDemo 的静态代码块 555。");
    }

    {
        System.out.println("CodeBlockDemo 的构造块 444。");
    }

    public CodeBlockDemo() {
        System.out.println("CodeBlockDemo 的构造方法 666。");
    }

    public static void main(String[] args) {
        System.out.println("~ ~ ~ ~ ~ ~ ~ CodeBlockDemo 的 main() 方法 777。");

        new CodeGeek();
        System.out.println("~ ~ ~ ~ ~ ~ ~");
        new CodeGeek();
        System.out.println("~ ~ ~ ~ ~ ~ ~");
        new CodeBlockDemo();
    }

}
