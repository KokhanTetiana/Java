package com.education.ztu.Task2;

public class Employee extends Person {
    private String position;
    private String company;
    private Car car;
    private static int counter = 0;


    public Employee(String firstname, String lastname, int age, Gender gender, Location location, String position, String company, Car car) {
        super(firstname, lastname, age, gender, location);
        this.position = position;
        this.company = company;
        this.car = car;
        counter++;
    }

    @Override
    public void getOccupation() {
        System.out.println("I am an employee.");
    }

    public static void showCounter() {
        System.out.println("Created employees: " + counter);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
