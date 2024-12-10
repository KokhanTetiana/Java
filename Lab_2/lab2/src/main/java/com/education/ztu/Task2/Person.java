package com.education.ztu.Task2;

public abstract class Person implements Human {
    private String firstname;
    private String lastname;
    private int age;
    private Gender gender;
    private Location location;
    protected String fullInfo;
    protected static int counter = 0;

    {
        firstname = "Tetiana";
        lastname = "Kokhan";
        age = 19;
        gender = Gender.FEMALE;
        location = Location.ZHYTOMYR;
        fullInfo = "";
        counter++;
    }
    public  Person(){}

    public Person(String firstname, String lastname, int age, Gender gender, Location location){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.location = location;
        this.fullInfo = firstname + " " + lastname + ", " + age + ", " + gender + ", " + location;
    }

    public abstract void getOccupation();

    @Override
    public void sayName(){
        System.out.println("Full Name: " + firstname + " " + lastname);
    }
    @Override
    public void sayAge() {
        System.out.println("Age: " + age);
    }

    @Override
    public void sayLocation() {
        System.out.println("Location: " + location);
    }

    @Override
    public void sayGender() {
        System.out.println("Gender: " + gender);
    }

    public String getFullInfo() {
        return fullInfo;
    }
    public static void showCounter() {
        System.out.println("Total Persons: " + counter);
    }


}
