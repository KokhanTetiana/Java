package com.education.ztu.Task3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;

public class Receipt {
    public static  void main(String[] args){
        String dateTime = "28.03.2019 13:25:12";
        String directoryPath = "directory_for_files";
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = directoryPath + File.separator + "receipt.txt";

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

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(formatter.toString());
            writer.close();
            System.out.println("Звіт записано у файл " + filePath);
        } catch (IOException e) {
            System.err.println("Помилка запису у файл: " + e.getMessage());
        } finally {
            formatter.close();
        }

        try {
            FileReader reader = new FileReader(filePath);
            int character;
            System.out.println("\nЗвіт з файлу:");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Помилка читання з файлу: " + e.getMessage());
        }
    }
}
