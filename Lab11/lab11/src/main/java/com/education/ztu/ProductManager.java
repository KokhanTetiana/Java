package com.education.ztu;

import java.sql.*;

public class ProductManager {
    public static void getAllProducts() {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String selectSQL = "SELECT * FROM products";
            ResultSet resultSet = statement.executeQuery(selectSQL);

            System.out.println("Список товарів:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");

                System.out.printf("ID: %d, Назва: %s, Ціна: %.2f, Кількість: %d%n", id, name, price, quantity);
            }

        } catch (SQLException e) {
            System.err.println("Помилка при отриманні даних з таблиці.");
            e.printStackTrace();
        }
    }

    public static void getProductsByPrice(double price, String condition) {
        String selectSQL = "SELECT * FROM products WHERE price " + condition + " ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            preparedStatement.setDouble(1, price);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Товари з ціною " + condition + " " + price + ":");

            boolean hasProducts = false;

            while (resultSet.next()) {
                hasProducts = true;
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double productPrice = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");

                System.out.printf("ID: %d, Назва: %s, Ціна: %.2f, Кількість: %d%n", id, name, productPrice, quantity);
            }

            if (!hasProducts) {
                System.out.println("Товари не знайдено.");
            }

        } catch (SQLException e) {
            System.err.println("Помилка при отриманні товарів за ціною.");
            e.printStackTrace();
        }
    }

    public static void addProductsWithTransaction() {
        String insertProduct1 = "INSERT INTO products (name, price, quantity) VALUES ('Товар 1', 20.50, 10)";
        String insertProduct2WithError = "INSERT INTO products (name, price, quantiy) VALUES ('Товар 2', 15.00, 5)";

        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement statement1 = connection.prepareStatement(insertProduct1);
                 PreparedStatement statement2 = connection.prepareStatement(insertProduct2WithError)) {

                statement1.executeUpdate();
                System.out.println("Перший товар успішно додано.");

                connection.setSavepoint("Savepoint1");
                System.out.println("Точка збереження створена.");

                statement2.executeUpdate();
                System.out.println("Другий товар успішно додано.");

                connection.commit();
            } catch (SQLException e) {
                System.err.println("Помилка при додаванні товарів: " + e.getMessage());
                System.out.println("Відновлення до точки збереження.");
                connection.rollback(connection.setSavepoint("Savepoint1"));
                connection.commit();
            }

        } catch (SQLException e) {
            System.err.println("Помилка транзакції: " + e.getMessage());
        }
    }
}
