package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
    private static final String URL  = "jdbc:mysql://localhost:3306/buoi5_db";
    private static final String USER = "root";
    private static final String PASS = "Kiettran3108@";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Chua nap duoc thu vien MySQL Driver: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
