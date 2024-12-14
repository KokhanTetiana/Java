package com.education.ztu.Task6;

public class Printer implements Runnable {
    private SharedResource sharedResource;

    public Printer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (true) {
            String data = sharedResource.getData();

            if (data.equalsIgnoreCase("exit")) {
                System.out.println("Програма завершується...");
                break;
            }

            System.out.println("Виведено: " + data);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
