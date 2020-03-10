package com.geek.transferValue;

public class TransferValueDemo {

    private void changeValue01(int age) {
        age = 30;
    }

    private void changeValue02(Person person) {
        person.setName("xxx");
    }

    private void changeValue03(String string) {
        string = "xxx";
    }


    public static void main(String[] args) {

        TransferValueDemo test = new TransferValueDemo();

        int age = 20;
        test.changeValue01(age);
        System.out.println("age = " + age);

        Person person = new Person("Geek");
        test.changeValue02(person);
        System.out.println("person _ name = " + person.getName());

        String string = "geek";
        test.changeValue03(string);
        System.out.println("string = " + string);
    }
}
