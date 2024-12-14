package com.education.ztu.Task2;


public class Main {
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("This is a printable message!");
        printable.print();
    }
}
