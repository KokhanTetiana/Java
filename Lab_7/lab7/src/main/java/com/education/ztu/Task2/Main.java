package com.education.ztu.Task2;


public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("Потік після створення: " + myThread.getState());

        myThread.start();
        System.out.println("Потік запущений...");

        System.out.println("Ім'я потоку: " + myThread.getName());
        System.out.println("Пріоритет потоку: " + myThread.getPriority());
        System.out.println("Чи живий потік? " + myThread.isAlive());
        System.out.println("Чи є потік демоном? " + myThread.isDaemon());

        myThread.setName("Програмування потоку");
        myThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Оновлене ім'я: " + myThread.getName());
        System.out.println("Оновлений пріоритет: " + myThread.getPriority());

        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Стан потоку після завершення: " + myThread.getState());

        Thread mainThread = Thread.currentThread();
        System.out.println("Ім'я головного потоку: " + mainThread.getName());
        System.out.println("Пріоритет головного потоку: " + mainThread.getPriority());
    }
}