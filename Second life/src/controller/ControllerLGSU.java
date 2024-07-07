package controller;

import controller.CustomAlertController;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    private Text AllertLG;

    @FXML
    private Pane PopUpSpace;

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
            showCustomAlert("Please enter username and password");
            return;
        }
    
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
    
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
    
            ResultSet rs = pstmt.executeQuery();
    
            if (rs.next()) {
                showCustomAlert("Welcome, " + username + "!");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/Navbar.fxml"));
                try {
                    AnchorPane navbarPane = loader.load();
                    // Dapatkan root dari scene saat ini
                    Scene scene = ButtonLG.getScene();
                    
                    // Ganti root dengan Navbar.fxml
                    scene.setRoot(navbarPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                showCustomAlert("Invalid username or password.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            showCustomAlert("An error occurred while connecting to the database.");
        }
    }
    
    private void handleSignUp() {
        String username = UNsu.getText();
        String password = passSU.getText();
    
        if (username.isEmpty() || password.isEmpty()) {
            showCustomAlert("Please enter username and password");
            return;
        }
    
        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";
    
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            showCustomAlert("User registered successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            showCustomAlert("An error occurred while connecting to the database.");
        }
    }

    private void showCustomAlert(String message) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AlertLogin.fxml"));
            Parent root = loader.load();
    
            // Get the controller instance
            CustomAlertController controller = loader.getController();
            if (controller != null) {
                controller.setMessage(message);
    
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.TRANSPARENT);
    
                Scene scene = new Scene(root);
                scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                stage.setScene(scene);
                stage.showAndWait();
            } else {
                System.err.println("Error: Controller is null.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadMainMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(ControllerLGSU.class.getResource("/view/MenuUtama.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    @FXML
    private void PindahDaftar(MouseEvent event){
        layerSembunyiMasuk.setVisible(true);
        TranslateTransition slideLayer = new TranslateTransition();
        slideLayer.setDuration(Duration.seconds(0.7));
        slideLayer.setNode(layerPenutup);
        slideLayer.setToX(450);
        slideLayer.play();

        TranslateTransition slideLogo = new TranslateTransition();
        slideLogo.setDuration(Duration.seconds(0.7));
        slideLogo.setNode(logo);
        slideLogo.setToX(450);
        slideLogo.play();
            
        FadeTransition keDaftar = new FadeTransition(Duration.seconds(0.5), layerSembunyiMasuk);
        keDaftar.setFromValue(0);
        keDaftar.setToValue(1);
        keDaftar.play();

        TranslateTransition transisidaftar = new TranslateTransition();
        transisidaftar.setDuration(Duration.seconds(0.7));
        transisidaftar.setNode(BGloginSU);
        transisidaftar.setToX(450);
        transisidaftar.play();

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

        TranslateTransition transisimasuk = new TranslateTransition();
        transisimasuk.setDuration(Duration.seconds(0.7));
        transisimasuk.setNode(BGloginSU);
        transisimasuk.setToX(0);
        transisimasuk.play();

        // Mengubah warna background BGloginSU selama transisi
        Timeline colorTransition = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(BGloginSU.styleProperty(), "-fx-background-color: #15616D;")),
            new KeyFrame(Duration.seconds(0.7), new KeyValue(BGloginSU.styleProperty(), "-fx-background-color: #FFFFFF;"))
        );
        colorTransition.play();

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