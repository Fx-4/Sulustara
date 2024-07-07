package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    private static final String url = "jdbc:sqlite:test.db";

    public static void main(String[] args) {
        // Buat tabel users
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users ("
                       + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                       + "username TEXT NOT NULL UNIQUE,"
                       + "password TEXT NOT NULL"
                       + ");";
            stmt.execute(sql);
            System.out.println("Table users created successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
        // Buat tabel produk
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                
                // Buat tabel produk dengan tambahan kolom deskripsiProduk dan gambar
                String sql = "CREATE TABLE IF NOT EXISTS produk ("
                           + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                           + "nama TEXT NOT NULL,"
                           + "harga REAL NOT NULL,"
                           + "stok INTEGER NOT NULL,"
                           + "deskripsiProduk TEXT,"
                           + "gambar BLOB,"
                           + "kategori TEXT NOT NULL"
                           + ");";
                
                stmt.execute(sql);
                System.out.println("Table produk created successfully!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
