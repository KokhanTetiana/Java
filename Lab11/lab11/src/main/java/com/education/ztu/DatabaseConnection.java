package com.education.ztu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("db");

    public static Connection getConnection() throws SQLException {
        try {
            String url = bundle.getString("db.url");
            String username = bundle.getString("db.username");
            String password = bundle.getString("db.password");
            String driverClass = bundle.getString("db.driverClass");
            Class.forName(driverClass);

            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver не знайдено.", e);
        }
    }
}
