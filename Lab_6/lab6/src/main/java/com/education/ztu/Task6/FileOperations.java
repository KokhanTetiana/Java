package com.education.ztu.Task6;

import java.io.File;
import java.io.IOException;

public class FileOperations {
    public static void main(String[] args) {
        File directory = new File("inner_directory");
        if (!directory.exists()) {
            boolean created = directory.mkdir();
            if (created) {
                System.out.println("Папка inner_directory успішно створена.");
            } else {
                System.out.println("Не вдалося створити папку.");
            }
        }
        System.out.println("Абсолютний шлях до папки: " + directory.getAbsolutePath());

        File parentDirectory = directory.getParentFile();
        if (parentDirectory != null) {
            System.out.println("Ім'я батьківської директорії: " + parentDirectory.getName());
        }

        File file1 = new File(directory, "file1.txt");
        File file2 = new File(directory, "file2.txt");

        try {
            if (file1.createNewFile()) {
                System.out.println("Файл file1.txt створений.");
            } else {
                System.out.println("Файл file1.txt вже існує.");
            }

            if (file2.createNewFile()) {
                System.out.println("Файл file2.txt створений.");
            } else {
                System.out.println("Файл file2.txt вже існує.");
            }
        } catch (IOException e) {
            System.err.println("Помилка при створенні файлів: " + e.getMessage());
        }

        if (file1.delete()) {
            System.out.println("Файл file1.txt видалений.");
        } else {
            System.out.println("Не вдалося видалити файл file1.txt.");
        }

        File renamedDirectory = new File("renamed_inner_directory");
        if (directory.renameTo(renamedDirectory)) {
            System.out.println("Папка перейменована в renamed_inner_directory.");
        } else {
            System.out.println("Не вдалося перейменувати папку.");
        }

        File directoryForFiles = new File("directory_for_files");
        if (directoryForFiles.exists() && directoryForFiles.isDirectory()) {
            File[] files = directoryForFiles.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    System.out.println("Ім'я: " + file.getName());
                    System.out.println("Тип: " + (file.isDirectory() ? "Папка" : "Файл"));
                    System.out.println("Розмір: " + file.length() + " байт");
                    System.out.println("----------------------");
                }
            } else {
                System.out.println("У папці directory_for_files немає файлів чи папок.");
            }
        } else {
            System.out.println("Папка directory_for_files не існує.");
        }

    }
}
