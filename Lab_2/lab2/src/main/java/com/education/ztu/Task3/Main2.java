package com.education.ztu.Task3;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Addition: " + Operation.addition(2, 4, 12));
        System.out.println("Subtraction: " + Operation.subtraction(100, 50));
        System.out.println("Multiplication: " + Operation.multiplication(4, 4, 4));
        System.out.println("Division: " + Operation.division(48.0, 2.0, 3.0));
        System.out.println("Average: " + Operation.average(2, 4, 6, 8));
        System.out.println("Maximum: " + Operation.maximum(7, 10, 1, 20, 16));
        System.out.println("Minimum: " + Operation.minimum(7, 10, 1, 20, 16));

        System.out.println("Locations:");
        for (Location location : Location.values()) {
            System.out.println(location);
        }
    }
}
