package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ControllerLGSU {

    @FXML
    private ImageView BGgambar;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Pane BGloginSU;

    @FXML
    private Text ButtonLG;

    @FXML
    private Text ButtonSU;

    @FXML
    private TextField UNlg;

    @FXML
    private TextField UNsu;

    @FXML
    private Rectangle layerPenutup;

    @FXML
    private Rectangle layerSembunyiDaftar;

    @FXML
    private Rectangle layerSembunyiMasuk;

    @FXML
    private PasswordField passLG;

    @FXML
    private PasswordField passSU;

    @FXML
    private Text txDaftar;

    @FXML
    private Text txMasuk;

    @FXML
    private ImageView logo;

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    @FXML
    private void initialize() {
        // Handle login button action
        ButtonLG.setOnMouseClicked(event -> handleLogin());
        // Handle sign-up button action
        ButtonSU.setOnMouseClicked(event -> handleSignUp());
    }

    private void handleLogin() {
        String username = UNlg.getText();
        String password = passLG.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!", "Please enter username and password");
            return;
        }

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                showAlert(AlertType.INFORMATION, "Login Successful", "Welcome, " + username + "!");
            } else {
                showAlert(AlertType.ERROR, "Login Failed", "Invalid username or password.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            showAlert(AlertType.ERROR, "Database Error", "An error occurred while connecting to the database.");
        }
    }

    private void handleSignUp() {
        String username = UNsu.getText();
        String password = passSU.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(AlertType.ERROR, "Form Error!", "Please enter username and password");
            return;
        }

        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            showAlert(AlertType.INFORMATION, "Registration Successful", "User registered successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            showAlert(AlertType.ERROR, "Database Error", "An error occurred while connecting to the database.");
        }
    }    

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void PindahDaftar(MouseEvent event){
        layerSembunyiMasuk.setVisible(true);
        TranslateTransition slideLayer = new TranslateTransition();
        slideLayer.setDuration(Duration.seconds(0.7));
        slideLayer.setNode(layerPenutup);
        slideLayer.setToX(365);
        slideLayer.play();

            TranslateTransition slideLogo = new TranslateTransition();
            slideLogo.setDuration(Duration.seconds(0.7));
            slideLogo.setNode(logo);
            slideLogo.setToX(365);
            slideLogo.play();
            
            FadeTransition keDaftar = new FadeTransition(Duration.seconds(0.5), layerSembunyiMasuk);
            keDaftar.setFromValue(0);
            keDaftar.setToValue(1);
            keDaftar.play();


        layerSembunyiDaftar.setVisible(false);
    }

    @FXML
    private void PindahMasuk(MouseEvent event){
        layerSembunyiDaftar.setVisible(true);
        TranslateTransition slideLayer = new TranslateTransition();
        slideLayer.setDuration(Duration.seconds(0.7));
        slideLayer.setNode(layerPenutup);
        slideLayer.setToX(0);
        slideLayer.play();

        TranslateTransition slideLogo = new TranslateTransition();
        slideLogo.setDuration(Duration.seconds(0.7));
        slideLogo.setNode(logo);
        slideLogo.setToX(0);
        slideLogo.play();

        FadeTransition keMasuk = new FadeTransition(Duration.seconds(0.5), layerSembunyiDaftar);
        keMasuk.setFromValue(0);
        keMasuk.setToValue(1);
        keMasuk.play();
        

        layerSembunyiMasuk.setVisible(false);        
    }

    @FXML
    private void WarnaDaftarMasuk(MouseEvent event){
        txDaftar.setFill(Color.BLUE);
    }

    @FXML
    private void WarnaDaftarKeluar(MouseEvent event){
        txDaftar.setFill(Color.BLACK);
    }

    @FXML
    private void WarnaMasukMasuk(MouseEvent event){
        txMasuk.setFill(Color.BLUE);
    }

    @FXML
    private void WarnaMasukKeluar(MouseEvent event){
        txMasuk.setFill(Color.BLACK);
    }

}