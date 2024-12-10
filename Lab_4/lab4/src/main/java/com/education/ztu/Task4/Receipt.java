package com.education.ztu.Task4;

import java.util.Formatter;

public class Receipt {
    public static  void main(String[] args){
        String dateTime = "28.03.2019 13:25:12";

        Formatter formatter = new Formatter();

        formatter.format("Дата та час покупки: %s%n", dateTime);
        formatter.format("===========================================%n");
        formatter.format("%-3s %-10s %-15s %-10s%n", "№", "Товар", "Категорія", "Ціна");
        formatter.format("===========================================%n");

        formatter.format("%-3d %-10s %-15s %10.2f ₴%n", 1, "Джинси", "Жіночий одяг", 1500.78);
        formatter.format("%-3d %-10s %-15s %10.2f ₴%n", 2, "Спідниця", "Жіночий одяг", 1000.56);
        formatter.format("%-3d %-10s %-15s %10.2f ₴%n", 3, "Краватка", "Чоловічий одяг", 500.78);
        formatter.format("%-3d %-10s %-15s %10.2f ₴%n", 4, "Сукня", "Жіночий одяг", 800.00);
        formatter.format("%-3d %-10s %-15s %10.2f ₴%n", 5, "Пальто", "Чоловічий одяг", 2500.50);
        formatter.format("%-3d %-10s %-15s %10.2f ₴%n", 6, "Піджак ", "Чоловічий одяг", 1250.30);
        formatter.format("%-3d %-10s %-15s %10.2f ₴%n", 7, "Шарф", "Жіночий одяг", 300.00);
        formatter.format("%-3d %-10s %-15s %10.2f ₴%n", 8, "Світшот", "Чоловічий одяг", 750.70);
        formatter.format("%-3d %-10s %-15s %10.2f ₴%n", 9, "Шапка", "Жіночий одяг", 210.50);
        formatter.format("%-3d %-10s %-15s %10.2f ₴%n", 10, "Рубашка", "Чоловічий одяг", 730.80);

        formatter.format("===========================================%n");
        formatter.format("%-29s %10.2f ₴%n", "Разом:", 9544.92);
        System.out.println(formatter);
        formatter.close();
    }
}
