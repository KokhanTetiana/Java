package com.education.ztu.Task6;

import java.util.Scanner;

public class Reader implements Runnable {
    private SharedResource sharedResource;
    private Scanner scanner;

    public Reader(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            System.out.print("Введіть рядок: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                sharedResource.setData(input);
                break;
            }
            sharedResource.setData(input);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
