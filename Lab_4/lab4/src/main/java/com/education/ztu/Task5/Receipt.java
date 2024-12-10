package com.education.ztu.Task5;

import java.util.Locale;
import java.util.ResourceBundle;
import java.text.NumberFormat;
import java.util.Scanner;

public class Receipt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Оберіть мову виводу чеку (ua - Українська, en - Англійська, es - Іспанська): ");
        String languageChoice = scanner.nextLine().trim().toLowerCase();

        Locale locale;

        switch (languageChoice) {
            case "en":
                locale = new Locale("en", "US");
                break;
            case "es":
                locale = new Locale("es", "ES");
                break;
            case "ua":
                locale = new Locale("ua", "UA");
                break;
            default:
                System.out.println("Невірний вибір. Використовуємо українську мову за замовчуванням.");
                locale = new Locale("ua", "UA");
                break;
        }

        ResourceBundle bundle = ResourceBundle.getBundle("data", locale);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

        String dateTime = "28.03.2019 13:25:12";
        System.out.println(bundle.getString("date_time") + ": " + dateTime);
        System.out.println("==================================================");
        System.out.printf("%-3s %-15s %-20s %-10s%n", "№", bundle.getString("item"), bundle.getString("category"), bundle.getString("price"));
        System.out.println("==================================================");
        System.out.printf("%-3d %-15s %-20s %10s%n", 1, bundle.getString("dress"), bundle.getString("womens_clothing"), currencyFormat.format(800.00));
        System.out.printf("%-3d %-15s %-20s %10s%n", 2, bundle.getString("skirt"), bundle.getString("womens_clothing"), currencyFormat.format(1250.60));
        System.out.printf("%-3d %-15s %-20s %10s%n", 3, bundle.getString("tie"), bundle.getString("mens_clothing"), currencyFormat.format(450.20));
        System.out.println("==================================================");
        System.out.printf("%-38s %10s%n", bundle.getString("total") + ":", currencyFormat.format(2500.80));
    }
}

