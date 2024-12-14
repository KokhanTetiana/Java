package com.education.ztu.Task5;

public class MyRunnable implements Runnable {
    private static int result = 1;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synchronized (MyRunnable.class) {
                System.out.print(result + " ");
                result++;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
