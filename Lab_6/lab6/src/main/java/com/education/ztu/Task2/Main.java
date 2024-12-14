package com.education.ztu.Task2;

import java.util.Scanner;

import static com.education.ztu.Task2.LoginValidation.checkCredentials;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();

        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();

        System.out.print("Підтвердіть пароль: ");
        String confirmPassword = scanner.nextLine();

        boolean isValid = checkCredentials(login, password, confirmPassword);

        if (isValid) {
            System.out.println("Вхідні дані коректні!");
        } else {
            System.out.println("Помилка у введених даних.");
        }
        scanner.close();
    }
}


