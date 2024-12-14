package com.education.ztu.Task3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Student.class;
        System.out.println("Class: " + clazz.getName());


        System.out.println("\nПоля класу:");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(field.getName() + " (" + field.getType() + ")");
        }

        System.out.println("\nМетоди класу:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.print(method.getName() + " - " + method.getReturnType());
            if (method.getParameterCount() > 0) {
                System.out.print(" (Parameters: ");
                for (Class<?> param : method.getParameterTypes()) {
                    System.out.print(param.getName() + " ");
                }
                System.out.print(")");
            }
            System.out.println();
        }

        Constructor<?> constructor = clazz.getConstructor(String.class, int.class, int.class, String.class);
        Student student1 = (Student) constructor.newInstance("Stepan", 18, 2, "Web-design");
        student1.introduce();

        Field privateField = clazz.getDeclaredField("age");
        privateField.setAccessible(true);
        privateField.set(student1, 23);
        System.out.println("Updated Age: " + privateField.get(student1));

        Method privateMethod = clazz.getDeclaredMethod("study");
        privateMethod.setAccessible(true);
        privateMethod.invoke(student1);

        student1.setCourse(4);
        System.out.println("Updated Course: " + student1.getCourse());
    }
}
