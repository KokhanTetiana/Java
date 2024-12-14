package com.education.ztu.Task5;

import java.io.*;

public class AddNewText {
    public static void main(String[] args) {
        String fileName = "directory_for_files/file1";
        String newText = "I learn Java";
        try {
            RandomAccessFile file = new RandomAccessFile(fileName, "rw");
            file.seek(file.length());

            file.writeBytes(newText + "\n");
            System.out.println("Додано рядок: " + newText);
            file.close();
            System.out.println("Новий рядок успішно додано в файл.");
        } catch (IOException e) {
            System.err.println("Помилка при роботі з файлом: " + e.getMessage());
        }
    }
}