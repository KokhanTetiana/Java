package com.education.ztu.Task6;

public class SharedResource {
    private String data = null;

    public synchronized void setData(String data) {
        this.data = data;
        notify();
    }

    public synchronized String getData() {
        try {
            while (data == null) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = data;
        data = null;
        return result;
    }
}
