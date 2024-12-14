package com.education.ztu.Task3;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10000; i += 10) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " - Розрахунок завершено!!!");
                return;
            }
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " - Розрахунок завершено!!!");
                return;
            }
        }
    }
}
