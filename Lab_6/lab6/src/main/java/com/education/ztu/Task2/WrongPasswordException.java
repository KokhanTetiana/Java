package com.education.ztu.Task2;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Невірний пароль.");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
