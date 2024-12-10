package com.education.ztu.Task2;

public class StringPractice {

    public static void stringOperations(String str) {
        System.out.println("Останній символ рядка: " + str.charAt(str.length() - 1));
        System.out.println("Чи закінчується на \"!!!\": " + str.endsWith("!!!"));
        System.out.println("Чи починається на \"I learn \": " + str.startsWith("I learn "));
        System.out.println("Чи містить \"Java\": " + str.contains("Java"));
        System.out.println("Позиція \"Java\": " + str.indexOf("Java"));
        String replaced = str.replace('a', 'o');
        System.out.println("Замінити \"a\" на \"o\": " + replaced);
        System.out.println("У верхньому регістрі: " + str.toUpperCase());
        System.out.println("У нижньому регістрі: " + str.toLowerCase());
        String cut = str.substring(str.indexOf("Java"), str.indexOf("Java") + "Java".length());
        System.out.println("Вирізаний підрядок \"Java\": " + cut);
    }
}
