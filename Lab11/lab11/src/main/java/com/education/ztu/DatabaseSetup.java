package com.education.ztu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void createTableAndInsertData() {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String createTableSQL = """
                    CREATE TABLE IF NOT EXISTS products (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        price DECIMAL(10, 2) NOT NULL,
                        quantity INT NOT NULL
                    );
                    """;
            statement.execute(createTableSQL);
            System.out.println("Таблиця 'products' створена.");

            String insertDataSQL = """
                    INSERT INTO products (name, price, quantity) VALUES
                    ('Milk', 35.50, 100),
                    ('Chocolate', 15.50, 200),
                    ('Juice', 9.75, 150),
                    ('Orange', 25.00, 80),
                    ('Apple', 28.20, 300),
                    ('Cheese', 45.99, 50),
                    ('Butter', 34.25, 10),
                    ('Tea', 40.00, 75),
                    ('Tomato', 68.50, 60),
                    ('Cake', 120.00, 180);
                    """;
            statement.addBatch(insertDataSQL);
            statement.executeBatch();

            System.out.println("Дані успішно додані до таблиці 'products'.");

        } catch (SQLException e) {
            System.err.println("Помилка при створенні таблиці або додаванні даних.");
            e.printStackTrace();
        }
    }

    public static void addMoreProducts() {
        String insertSQL = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            connection.setAutoCommit(false);

            preparedStatement.setString(1, "Pudding");
            preparedStatement.setDouble(2, 25.50);
            preparedStatement.setInt(3, 12);
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Coffee");
            preparedStatement.setDouble(2, 14.00);
            preparedStatement.setInt(3, 5);
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Товар 13");
            preparedStatement.setDouble(2, 9.99);
            preparedStatement.setInt(3, 150);
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Ice cream");
            preparedStatement.setDouble(2, 18.25);
            preparedStatement.setInt(3, 50);
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Feta");
            preparedStatement.setDouble(2, 85.75);
            preparedStatement.setInt(3, 30);
            preparedStatement.addBatch();

            preparedStatement.executeBatch();
            connection.commit();
            System.out.println("Додано ще 5 товарів у таблицю 'products'!");

        } catch (SQLException e) {
            System.err.println("Помилка при додаванні товарів.");
            e.printStackTrace();
        }
    }
}
