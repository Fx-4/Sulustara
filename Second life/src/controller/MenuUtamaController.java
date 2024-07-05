package controller;

import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class MenuUtamaController {

    @FXML
    private VBox layout;
    @FXML
    private HBox iklanContainer;
    
    @FXML
    private ImageView iklan1;
    @FXML
    private ImageView iklan2;
    @FXML
    private ImageView iklan3;
    @FXML
    private ImageView iklan4;
    @FXML
    private ImageView iklan5;

    @FXML
    private ImageView produk1;
    @FXML
    private ImageView produk2;
    @FXML
    private ImageView produk3;
    @FXML
    private ImageView produk4;
    @FXML
    private ImageView produk5;

    @FXML
    public void initialize() {

        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/Navbar.fxml"));
            VBox Base = loader.load();
            ControllerNavbar controllerNavbar = loader.getController();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }







        // Load advertisement images
        try {
            iklan1.setImage(new Image(getClass().getResourceAsStream("/Images/1.png")));
            iklan2.setImage(new Image(getClass().getResourceAsStream("/Images/2.png")));
            iklan3.setImage(new Image(getClass().getResourceAsStream("/Images/3.png")));
            iklan4.setImage(new Image(getClass().getResourceAsStream("/Images/4.png")));
            iklan5.setImage(new Image(getClass().getResourceAsStream("/Images/5.png")));
        } catch (NullPointerException e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }

        // Load product images (adjust path as necessary)
        try {
            produk1.setImage(new Image(getClass().getResourceAsStream("/Images/p1.png")));
            produk2.setImage(new Image(getClass().getResourceAsStream("/Images/p2.png")));
            produk3.setImage(new Image(getClass().getResourceAsStream("/Images/p3.png")));
            produk4.setImage(new Image(getClass().getResourceAsStream("/Images/p4.png")));
            produk5.setImage(new Image(getClass().getResourceAsStream("/Images/p5.png")));
        } catch (NullPointerException e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }

        // Set up advertisement rotation
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(3), e -> rotateAdvertisements())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void rotateAdvertisements() {
        ImageView first = (ImageView) iklanContainer.getChildren().remove(0);
        iklanContainer.getChildren().add(first);
    }
}
