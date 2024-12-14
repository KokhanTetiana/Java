package com.education.ztu.Task7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ArchiveOperations {
    public static void main(String[] args) {
        File directoryForFiles = new File("directory_for_files");
        File zipFile = new File("archive.zip");

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            if (directoryForFiles.exists() && directoryForFiles.isDirectory()) {
                for (File file : directoryForFiles.listFiles()) {
                    if (file.isFile()) {
                        try (FileInputStream fis = new FileInputStream(file)) {
                            zipOut.putNextEntry(new ZipEntry(file.getName()));
                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = fis.read(buffer)) > 0) {
                                zipOut.write(buffer, 0, length);
                            }
                            zipOut.closeEntry();
                            System.out.println("Додано файл: " + file.getName());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            System.out.println("-------------");
            System.out.println("Файли в архіві:");
            while ((entry = zipIn.getNextEntry()) != null) {
                System.out.println(entry.getName());
                zipIn.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
