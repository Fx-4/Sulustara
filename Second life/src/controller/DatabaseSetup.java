package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    private static final String url = "jdbc:sqlite:test.db";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users ("
                       + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                       + "username TEXT NOT NULL UNIQUE,"
                       + "password TEXT NOT NULL"
                       + ");";
            stmt.execute(sql);
            System.out.println("Table created successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
