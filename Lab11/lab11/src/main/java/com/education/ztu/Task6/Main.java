package com.education.ztu.Task6;

import com.education.ztu.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                System.out.println("З'єднання з базою даних успішне!");
                ProductDAO productDAO = new ProductDAO(connection);

                Product newProduct = new Product(0, "Товар 1", 100.50, 20);
                productDAO.create(newProduct);
                System.out.println("Товар додано: " + newProduct);

                List<Product> products = productDAO.getAll();
                System.out.println("Всі товари:");
                for (Product product : products) {
                    System.out.println(product);
                }

                newProduct.setPrice(110.00);
                productDAO.update(newProduct);
                System.out.println("Оновлений товар: " + newProduct);

                productDAO.delete(newProduct.getId());
                System.out.println("Товар з ID " + newProduct.getId() + " видалено.");
            }
        } catch (SQLException e) {
            System.err.println("Помилка з'єднання з базою даних.");
            e.printStackTrace();
        }
    }
}
