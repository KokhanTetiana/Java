package com.education.ztu.Task6;

import java.time.LocalDateTime;
import java.time.Year;

public class DatePractice {
    public static void main(String[] args) {
        LocalDateTime startOfLab = LocalDateTime.of(2024, 11, 6, 17, 0, 0);

        System.out.println("Дата початку лабораторної: " + startOfLab);
        System.out.println("День тижня: " + startOfLab.getDayOfWeek());
        System.out.println("День у році: " + startOfLab.getDayOfYear());
        System.out.println("Місяць: " + startOfLab.getMonth());
        System.out.println("Рік: " + startOfLab.getYear());
        System.out.println("Години: " + startOfLab.getHour());
        System.out.println("Хвилини: " + startOfLab.getMinute());
        System.out.println("Секунди: " + startOfLab.getSecond());

        Year year = Year.of(startOfLab.getYear());
        System.out.println("Чи є рік високосним? " + year.isLeap());
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("===============================");
        System.out.println("Порівняння з поточним часом:");
        if (currentTime.isAfter(startOfLab)) {
            System.out.println("Поточний час після початку лабораторної.");
        } else if (currentTime.isBefore(startOfLab)) {
            System.out.println("Поточний час до початку лабораторної.");
        } else {
            System.out.println("Поточний час дорівнює часу початку лабораторної.");
        }
        System.out.println("============================");
        LocalDateTime modifiedDate = startOfLab
                .withYear(2025)
                .withMonth(12)
                .withDayOfMonth(10)
                .withHour(21)
                .withMinute(27)
                .withSecond(55);
        System.out.println("Змінена дата та час: " + modifiedDate);
    }
}
