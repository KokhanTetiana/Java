package com.education.ztu.Task4;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String textFileFirst = "directory_for_files/file1";
        String textFileCopy = "directory_for_files/file1_copy";
        String imageFirst = "directory_for_files/image1.jpg";
        String imageCopy = "directory_for_files/image1_copy.jpg";

        copyFiles(textFileFirst, textFileCopy, imageFirst, imageCopy);
    }

    public static void copyFiles(String textFileSource, String textFileDestination, String imageSource, String imageDestination) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(textFileSource));
                BufferedWriter writer = new BufferedWriter(new FileWriter(textFileDestination));
                FileInputStream inStream = new FileInputStream(imageSource);
                FileOutputStream outStream = new FileOutputStream(imageDestination)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Текстовий файл скопійовано успішно!");

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            System.out.println("Зображення скопійовано успішно!");
        } catch (IOException e) {
            System.err.println("Помилка копіювання файлів: " + e.getMessage());
        }
    }
}
