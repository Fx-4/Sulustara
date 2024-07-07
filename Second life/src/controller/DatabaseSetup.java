package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    private static final String URL = "jdbc:sqlite:test.db";

    public static void main(String[] args) {
        // Load SQLite JDBC driver
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
            return;
        }

        // Buat tabel users
        try (Connection conn = DriverManager.getConnection(URL);
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
        try (Connection conn = DriverManager.getConnection(URL)) {
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

        // Buat tabel profile
        try (Connection conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();

                // Buat tabel profile
                String sql = "CREATE TABLE IF NOT EXISTS profile ("
                           + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                           + "alamat TEXT NOT NULL,"
                           + "email TEXT NOT NULL,"
                           + "jenis_kelamin TEXT NOT NULL,"
                           + "nama TEXT NOT NULL,"
                           + "no_handphone TEXT NOT NULL,"
                           + "username TEXT NOT NULL,"
                           + "foto_profile BLOB"
                           + ");";

                stmt.execute(sql);
                System.out.println("Table profile created successfully!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
