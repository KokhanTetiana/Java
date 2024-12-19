package com.education.ztu;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                System.out.println("З'єднання з базою даних успішне!");

                DatabaseSetup.createTableAndInsertData();

                ProductManager.getAllProducts();
                ProductManager.getProductsByPrice(30.0, "<");
                DatabaseCleanup.deleteAllProducts();
                ProductManager.addProductsWithTransaction();
                ProductManager.getProductsByPrice(0, ">");
            }
        } catch (SQLException e) {
            System.err.println("Помилка з'єднання з базою даних.");
            e.printStackTrace();
        }
    }
}