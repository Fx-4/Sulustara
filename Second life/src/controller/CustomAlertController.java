package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class CustomAlertController {

    @FXML
    private Text AllertLG;


    public void setAlertMessage(String message) {
        AllertLG.setText(message);
    }

    public void setMessage(String message) {
        AllertLG.setText(message);
        
        // Set timeout to close the alert and load main menu
        new Thread(() -> {
            try {
                Thread.sleep(1500); // Adjust the delay as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                closeAlertAndLoadMainMenu();
            });
        }).start();
    }

        private void closeAlertAndLoadMainMenu() {
        // Close the alert's stage
        AllertLG.getScene().getWindow().hide();

        // Load main menu
        // You can call a method to load the main menu here, for example:
        // Main.loadMainMenu();
    }
}

