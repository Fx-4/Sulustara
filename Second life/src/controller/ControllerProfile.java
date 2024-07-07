package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerProfile {

    @FXML
    private TextField alamatField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField jenisKelaminField;

    @FXML
    private TextField namaField;

    @FXML
    private TextField noHandphoneField;

    @FXML
    private TextField usernameField;

    @FXML
    private ImageView fotoProfile;

    private static final String URL = "jdbc:sqlite:test.db";

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    @FXML
    private void saveProfile() {
        String sql = "INSERT INTO profile(alamat, email, jenis_kelamin, nama, no_handphone, username, foto_profile) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, alamatField.getText());
            pstmt.setString(2, emailField.getText());
            pstmt.setString(3, jenisKelaminField.getText());
            pstmt.setString(4, namaField.getText());
            pstmt.setString(5, noHandphoneField.getText());
            pstmt.setString(6, usernameField.getText());
            // Assume you have a method to convert ImageView to byte array
            byte[] fotoProfileBytes = {}; // convert ImageView to byte array if necessary
            pstmt.setBytes(7, fotoProfileBytes);
            pstmt.executeUpdate();
            System.out.println("Profile saved successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
