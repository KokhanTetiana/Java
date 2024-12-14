package com.education.ztu.Task2;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = """
            Іваненко Іван Іванович, 48 років, директор, досвід роботи 14 років, народився 23.02.1967, телефон: +380961234567, email: ivan@example.com
            Петренко Петро Петрович, 40 років, водій, досвід роботи 8 років, народився 15.09.1975, телефон: +380969876543, email: petro@example.com
            Онищук Дарина Сергіївна, 25 років, бухгалтер, досвід роботи 3 роки, народився 10.02.1999, телефон: +380934567890, email: daria@example.com
            Василенко Христина Андріївна, 37 років, заступник директора, досвід роботи 10 років, народилась 22.06.1983, телефон: +380981238970, email: chrystyna@example.com
            Зиниця Степан Миколайович, 28 років, системний адміністратор, досвід роботи 4 роки, народився 02.05.1995, телефон: +380675674531, email: stepan@example.com
            """;

        Pattern phonePattern = Pattern.compile("\\+380\\d{9}");
        Matcher phoneMatcher = phonePattern.matcher(text);
        List<String> phones = new ArrayList<>();
        while (phoneMatcher.find()) {
            phones.add(phoneMatcher.group());
        }

        Pattern emailPattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,7}\\b");
        Matcher emailMatcher = emailPattern.matcher(text);
        List<String> emails = new ArrayList<>();
        while (emailMatcher.find()) {
            emails.add(emailMatcher.group());
        }

        System.out.println("Номери телефонів:");
        phones.forEach(System.out::println);

        System.out.println("\nЕмейли:");
        emails.forEach(System.out::println);

        Pattern datePattern = Pattern.compile("(\\d{2})\\.(\\d{2})\\.(\\d{4})");
        Matcher dateMatcher = datePattern.matcher(text);
        String updatedText = dateMatcher.replaceAll("$3-$2-$1");

        System.out.println("\nТекст після зміни дат народження:");
        System.out.println(updatedText);

        updatedText = updatedText.replaceAll("директор", "головний директор")
                .replaceAll("бухгалтер", "старший бухгалтер")
                .replaceAll("системний адміністратор", "фахівець з технічної підтримки");

        System.out.println("\nТекст після зміни посад:");
        System.out.println(updatedText);
    }
}