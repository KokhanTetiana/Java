package com.education.ztu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseCleanup {
    public static void deleteAllProducts() {
        String deleteSQL = "DELETE FROM products";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Видалено записів: " + rowsAffected);

        } catch (SQLException e) {
            System.err.println("Помилка при видаленні записів.");
            e.printStackTrace();
        }
    }
}
