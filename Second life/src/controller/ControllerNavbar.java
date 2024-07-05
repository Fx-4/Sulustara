package controller;


import javafx.fxml.FXML;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ControllerNavbar implements Initializable {

    @FXML
    private AnchorPane MenuUtama;

    @FXML
    private Rectangle area1;

    @FXML
    private Rectangle area2;

    @FXML
    private Rectangle area3;

    @FXML
    private Rectangle area4;

    @FXML
    private Rectangle area5;

    @FXML
    private Rectangle area6;

    @FXML
    private Rectangle area7;

    @FXML
    private Rectangle btPesan;

    @FXML
    private Rectangle btDiskusi;

    @FXML
    private Rectangle btUlasan;

    @FXML
    private Rectangle btPesanBantuan;

    @FXML
    private Rectangle btPesananDikomplain;

    @FXML
    private Rectangle btPakaianDanTekstil;

    @FXML
    private Rectangle btPlastik;

    @FXML
    private Rectangle btAksesorisDanFurnitur;

    @FXML
    private Rectangle btKertasDanKardus;

    @FXML
    private BorderPane paneUtama;

    @FXML
    private Rectangle layerPenutup;

    @FXML
    private Pane kategoriPane;

    @FXML
    private Pane keranjangPane;

    @FXML
    private Pane notifikasiPane;

    @FXML
    private Pane mailPane;


    private void AnimasiMuncul(Pane pane){
        FadeTransition fade = new FadeTransition(Duration.seconds(0.1), pane);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
        layerPenutup.setVisible(true);
    }

    private void AnimasiKeluar(Pane pane){
        FadeTransition fade = new FadeTransition(Duration.seconds(0.1), pane);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        layerPenutup.setVisible(false);
    }

    private void WarnaMuncul(Rectangle rectangle){
        rectangle.setFill(Color.BLACK);
        rectangle.setOpacity(0.1);
    }

    private void WarnaKeluar(Rectangle rectangle){
        rectangle.setFill(null);
        rectangle.setOpacity(0);
    }
    
    @FXML
    private void KategoriMuncul(MouseEvent event){
        area1.setVisible(true);
        area2.setVisible(true);
        kategoriPane.setVisible(true);
        AnimasiMuncul(kategoriPane);
    }

    @FXML
    private void KategoriKeluar(MouseEvent event){
        area1.setVisible(false);
        area2.setVisible(false);
        kategoriPane.setVisible(false);
        AnimasiKeluar(kategoriPane);
    }

    @FXML
    private void KeranjangMuncul(MouseEvent event){
        area2.setVisible(true);
        area4.setVisible(true);
        keranjangPane.setVisible(true);
        AnimasiMuncul(keranjangPane);
    }

    @FXML
    private void KeranjangKeluar(MouseEvent event){
        area2.setVisible(false);
        area4.setVisible(false);
        keranjangPane.setVisible(false);
        AnimasiKeluar(keranjangPane);
    }

    @FXML
    private void NotifikasiMuncul(MouseEvent event){
        area3.setVisible(true);
        area5.setVisible(true);
        notifikasiPane.setVisible(true);
        AnimasiMuncul(notifikasiPane);
    }

    @FXML
    private void NotifikasiKeluar(MouseEvent event){
        area3.setVisible(false);
        area5.setVisible(false);
        notifikasiPane.setVisible(false);
        AnimasiKeluar(notifikasiPane);
    }

    @FXML
    private void MailMuncul(MouseEvent event){
        area4.setVisible(true);
        area6.setVisible(true);
        mailPane.setVisible(true);
        AnimasiMuncul(mailPane);
    }

    @FXML
    private void MailKeluar(MouseEvent event){
        area4.setVisible(false);
        area6.setVisible(false);
        mailPane.setVisible(false);
        AnimasiKeluar(mailPane);
    }

    @FXML
    private void WarnaPesan(MouseEvent event){
        if (btPesan.getFill() == Color.BLACK) {
            WarnaKeluar(btPesan);
        }else{
            WarnaMuncul(btPesan);
        }
    }

    @FXML
    private void WarnaDiskusi(MouseEvent event){
        if (btDiskusi.getFill() == Color.BLACK) {
            WarnaKeluar(btDiskusi);
        }else{
            WarnaMuncul(btDiskusi);
        }
    }

    @FXML
    private void WarnaUlasan(MouseEvent event){
        if (btUlasan.getFill() == Color.BLACK) {
            WarnaKeluar(btUlasan);
        }else{
            WarnaMuncul(btUlasan);
        }
    }

    @FXML
    private void WarnaPesanBantuan(MouseEvent event){
        if (btPesanBantuan.getFill() == Color.BLACK) {
            WarnaKeluar(btPesanBantuan);
        }else{
            WarnaMuncul(btPesanBantuan);
        }
    }

    @FXML
    private void WarnaPesananDikomplain(MouseEvent event){
        if (btPesananDikomplain.getFill() == Color.BLACK) {
            WarnaKeluar(btPesananDikomplain);
        }else{
            WarnaMuncul(btPesananDikomplain);
        }
    }

    @FXML
    private void WarnaPakaianDanTekstil(MouseEvent event){
        if (btPakaianDanTekstil.getFill() == Color.BLACK) {
            WarnaKeluar(btPakaianDanTekstil);
        }else{
            WarnaMuncul(btPakaianDanTekstil);
        }
    }

    @FXML
    private void WarnaPlastik(MouseEvent event){
        if (btPlastik.getFill() == Color.BLACK) {
            WarnaKeluar(btPlastik);
        }else{
            WarnaMuncul(btPlastik);
        }
    }

    @FXML
    private void WarnaAksesorisDanFurnitur(MouseEvent event){
        if (btAksesorisDanFurnitur.getFill() == Color.BLACK) {
            WarnaKeluar(btAksesorisDanFurnitur);
        }else{
            WarnaMuncul(btAksesorisDanFurnitur);
        }
    }

    @FXML
    private void WarnaKertasDanKardus(MouseEvent event){
        if (btKertasDanKardus.getFill() == Color.BLACK) {
            WarnaKeluar(btKertasDanKardus);
        }else{
            WarnaMuncul(btKertasDanKardus);
        }
    }

    @FXML
    private void MenuUtama(MouseEvent event){
        OpenScene object = new OpenScene();
        Pane MenuUtama = object.getPane("MenuUtama");
        MenuUtama.setPrefSize(1920, 1011);
        paneUtama.setCenter(MenuUtama);
    }

    @FXML
    private void MenuKeranjang(MouseEvent event){
        OpenScene object = new OpenScene();
        Pane MenuKategori = object.getPane("cart");
        MenuKategori.setPrefSize(1920, 1011);
        paneUtama.setCenter(MenuKategori);
    }

    @FXML
    private void MenuProfile(MouseEvent event){
        OpenScene object = new OpenScene();
        Pane MenuProfile = object.getPane("profile");
        MenuProfile.setPrefSize(1920, 1011);
        paneUtama.setCenter(MenuProfile);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OpenScene object = new OpenScene();
        Pane MenuUtama = object.getPane("MenuUtama");
        MenuUtama.setPrefSize(1920, 1011);
        paneUtama.setCenter(MenuUtama);
    }

}
