package com.education.ztu.Task4;

public class AnnotationExample {
    public static void main(String[] args) {
        try {
            Class<Student> studentClass = Student.class;

            if (studentClass.isAnnotationPresent(StudentInformation.class)) {
                StudentInformation studentInfo = studentClass.getAnnotation(StudentInformation.class);

                System.out.println("Student Information:");
                System.out.println("Name: " + studentInfo.name());
                System.out.println("Age: " + studentInfo.age());
                System.out.println("Course: " + studentInfo.course());
            } else {
                System.out.println("Анотація StudentInformation відсутня.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
