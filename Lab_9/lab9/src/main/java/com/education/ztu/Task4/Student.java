package com.education.ztu.Task4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface StudentInformation {
    String name() default "Unknown";
    int age() default 18;
    String course() default "Not specified";
}

@StudentInformation(name = "Stepan", age = 19, course = "Web-design")
public class Student {
    private String name;
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
        System.out.println("Hi, my name is " + name + ". I'm " + age + " years old and studying " + major + ".");
    }
}
