package com.education.ztu.Task4;

public class MyRunnable implements Runnable {
    private static int result = 1;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            printProgression();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void printProgression() {
        System.out.print(result + " ");
        result++;
    }
}
