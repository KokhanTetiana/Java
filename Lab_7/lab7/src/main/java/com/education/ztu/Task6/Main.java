package com.education.ztu.Task6;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread readerThread = new Thread(new Reader(sharedResource), "Reader");
        Thread printerThread = new Thread(new Printer(sharedResource), "Printer");

        readerThread.start();
        printerThread.start();

        try {
            readerThread.join();
            printerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Програма завершена.");
    }
}
