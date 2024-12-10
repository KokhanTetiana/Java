package com.education.ztu.Task2;

public interface Human {
    void sayName();
    void sayAge();
    void sayLocation();
    void sayGender();

    default void whoIAm(){
        System.out.println(" I am a human!");
    }
}
