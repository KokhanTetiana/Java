package com.education.ztu.Task2;

public class LoginValidation {
    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("[a-zA-Z0-9_]{1,19}")) {
                throw new WrongLoginException("Логін повинен містити лише латинські літери, цифри та знак підкреслення, і його довжина має бути менше 20 символів.");
            }
            if (!password.matches("[a-zA-Z0-9_]{1,19}")) {
                throw new WrongPasswordException("Пароль повинен містити лише латинські літери, цифри та знак підкреслення, і його довжина має бути менше 20 символів.");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Паролі не збігаються.");
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
