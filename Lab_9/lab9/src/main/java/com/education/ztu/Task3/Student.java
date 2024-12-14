package com.education.ztu.Task3;

public class Student {
    public String name;
    private int age;
    private int course;
    private String major;

    public Student(String name, int age, int course, String major) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.major = major;
    }

    public void introduce() {
        System.out.println("Hello, my name is " + name + ", I am " + age + " years old, studying " + major + " at course " + course + ".");
    }

    private void study() {
        System.out.println(name + " is studying " + major + ".");
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
