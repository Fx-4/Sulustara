package Controller;

import java.io.IOException;

import Model.SearchListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SidePaneController {

    private Stage stage;
    private Scene scene;

    @FXML
    private Pane AkunButton;

    @FXML
    private Pane PakaianDanTekstil;

    @FXML
    private Pane DekorasiDanAksesoris;

    @FXML
    private Button JualBarangButton;

    @FXML
    private Pane Plastik;

    @FXML
    private Pane KertasDanKardus;

    @FXML
    private TextField SearchBar;

    @FXML
    void GoToAccount(MouseEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GraphicUserInterface/ProfilePage.fxml"));
            scene = new Scene(loader.load());
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("SecondLife");
            stage.show();
    }

    @FXML
    void GoToPakaianDanTekstil(MouseEvent event) throws IOException {

        SearchListener temp = new SearchListener();
            temp.setIskategoriSearch(true);
            temp.setSearch("Pakaian & Tekstil");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GraphicUserInterface/SearchResultPage.fxml"));
            scene = new Scene(loader.load());
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("SecondLife");
            stage.show();

    }

    @FXML
    void GoToDekorasiDanAksesoris(MouseEvent event) throws IOException {

        SearchListener temp = new SearchListener();
            temp.setIskategoriSearch(true);
            temp.setSearch("Dekorasi & Aksesoris");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GraphicUserInterface/SearchResultPage.fxml"));
            scene = new Scene(loader.load());
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("SecondLife");
            stage.show();

    }

    @FXML
    void GoToKatalogManage(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GraphicUserInterface/KatalogAddPage.fxml"));
            scene = new Scene(loader.load());
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("SecondLife");
            stage.show();


    }

    @FXML
    void GoToPlastik(MouseEvent event) throws IOException {

        SearchListener temp = new SearchListener();
            temp.setIskategoriSearch(true);
            temp.setSearch("Plastik");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GraphicUserInterface/SearchResultPage.fxml"));
            scene = new Scene(loader.load());
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("SecondLife");
            stage.show();

    }

    @FXML
    void GoToKertasDanKardus(MouseEvent event) throws IOException {

            SearchListener temp = new SearchListener();
            temp.setIskategoriSearch(true);
            temp.setSearch("Kertas & Kardus");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GraphicUserInterface/SearchResultPage.fxml"));
            scene = new Scene(loader.load());
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("SecondLife");
            stage.show();

    }

    @FXML
    void SearchBarang(KeyEvent event) {

    }

}
