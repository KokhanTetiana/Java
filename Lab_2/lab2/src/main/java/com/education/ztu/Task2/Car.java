package com.education.ztu.Task2;

public class Car {
    private String brand;
    private Engine engine;

    public Car(String brand) {
        this.brand = brand;
        this.engine = new Engine();
    }
    public Engine getEngine() {
        return engine;
    }
    public String getBrand() {
        return brand;
    }

    public boolean engineIsRunning(){
        return engine.isEngineWorks();
    }


    public class Engine {
        private boolean engineWorks = false;

        public void startEngine() {
            engineWorks = true;
            System.out.println("Engine started.");
        }

        public void stopEngine() {
            engineWorks = false;
            System.out.println("Engine stopped.");
        }

        public boolean isEngineWorks() {
            return engineWorks;
        }
    }

}
