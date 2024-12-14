package com.education.ztu.Task3;


public class Main {
    public static void main(String[] args) {
        MyRunnable task = new MyRunnable();

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        Thread thread3 = new Thread(task, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(2000);
            System.out.println("Перериваємо потоки...");
            thread1.interrupt();
            thread2.interrupt();
            thread3.interrupt();
            thread1.join();
            thread2.join();
            thread3.join();
            System.out.println("Розрахунок завершено!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
