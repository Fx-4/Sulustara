package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import Model.SearchListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KategoriCardController implements Initializable {
    Scene scene;
    Stage stage;

    @FXML
    private Pane ButtonPergi;

    @FXML
    private ImageView GambarKategori;

    @FXML
    private Label NamaKategori;

    static private ArrayList<String[]> kategorilist = new ArrayList<>();
    private String[] DekorasiDanAksesoris = { "DEKORASI & AKSESORIS", "/ImageAsset/Foto kategori/Dekorasi & Aksesoris.png" };
    private String[] PakaianDanTekstil = { "PAKAIAN & TEKSTIL", "/ImageAsset/Foto kategori/Pakaian & Tekstil.png" };
    private String[] KertasDanKardus = { "KERTAS & KARDUS", "/ImageAsset/Foto kategori/Kertas & Kardus.png" };
    private String[] Plastik = { "PLASTIK", "/ImageAsset/Foto kategori/Plastik.png" };

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        kategorilist.add(DekorasiDanAksesoris);
        kategorilist.add(Plastik);
        kategorilist.add(KertasDanKardus);
        kategorilist.add(PakaianDanTekstil);

        Random picker = new Random();
        String[] kategoritemp;
        kategoritemp = kategorilist.get(picker.nextInt(kategorilist.size()));
        NamaKategori.setText(kategoritemp[0]);
        Image x = new Image(kategoritemp[1]);
        GambarKategori.setImage(x);
        System.out.println(NamaKategori.getText());

        kategorilist.remove(kategorilist.indexOf(kategoritemp));
    }

    @FXML
    void SeacrhKatalog(MouseEvent event) throws IOException {
        SearchListener temp = new SearchListener();
        temp.setIskategoriSearch(true);
        if (NamaKategori.getText().equals("PLASTIK")) {
            temp.setSearch("Plastik");
        } else if (NamaKategori.getText().equals("KERTAS & KARDUS")) {
            temp.setSearch("Kertas & Kardus");
        } else if (NamaKategori.getText().equals("PAKAIAN & TEKSTIL")) {
            temp.setSearch("Pakaian & Tekstil");
        } else {
            temp.setSearch("Dekorasi & Aksesoris");
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GraphicUserInterface/SearchResultPage.fxml"));
        scene = new Scene(loader.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("SecondLife");
        stage.show();

    }
}
