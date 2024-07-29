package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Barang;
import Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KatalogEditDeletePageController implements Initializable {
    static int IDbarang = 0;

    @FXML
    private Button EditButton;

    @FXML
    private TextField FieldBrandBarang;

    @FXML
    private TextArea FieldDeskripsi;

    @FXML
    private TextField FieldHargaBarang;

    @FXML
    private TextField FieldNamaBarang;

    @FXML
    private TextField FieldUkuranBarang;

    @FXML
    private TextField FieldWarnaBarang;

    @FXML
    private ImageView GambarBarang;

    @FXML
    private Button KategoriKertasDanKardus;

    @FXML
    private Button KategoriPakaianDanTekstil;

    @FXML
    private Button KategoriPlastik;

    @FXML
    private Button KategoriDekorasiDanAksesoris;

    @FXML
    private Button HapusButton;

    @FXML
    private Button BatalButton;

    @FXML
    private ChoiceBox<String> PilihKondisi;

    private Button SelectedKategori;

    private String[] Kondisi = { "Seperti Baru", "Layak Pakai", "Tua" };
    private String PilihanKategori;
    Image DataGambarBarang;
    File DataGambarBarangSimpan;

    DatabaseModel DB = new DatabaseModel();
    User session = new User();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        DB.ConnectToDataBase("src/SecondLifeDatabase.db");
        PilihKondisi.getItems().addAll(Kondisi);
        User DataCurrentUser = DB.SelectUser(session.getID());
        Barang barang = DB.SelectBarang(IDbarang);
        FieldNamaBarang.setText(barang.getNamaBarang());
        FieldHargaBarang.setText(barang.getHargaBarang());
        PilihKondisi.setValue(barang.getKondisi());
        FieldBrandBarang.setText(barang.getBrandBarang());
        FieldWarnaBarang.setText(barang.getWarnaBarang());
        FieldUkuranBarang.setText(barang.getUkuranBarang());
        FieldDeskripsi.appendText(barang.getDeskripsiBarang());
        GambarBarang.setImage(barang.getGambar());
        PilihanKategori = barang.getKategoriBarang();
        session = DataCurrentUser;
        DB.DisconnectFromDataBase();

        if (PilihanKategori.equals("Otomotif")) {
            KategoriDekorasiDanAksesoris.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #16606D;\r\n" + //
                    "    -fx-border-color: #16606D;\r\n" + //
                    "    -fx-text-fill: #ffffff;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");
            SelectedKategori = KategoriDekorasiDanAksesoris;
        } else if (PilihanKategori.equals("Fashion")) {
            KategoriPakaianDanTekstil.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #16606D;\r\n" + //
                    "    -fx-border-color: #16606D;\r\n" + //
                    "    -fx-text-fill: #ffffff;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");
            SelectedKategori = KategoriPakaianDanTekstil;
        } else if (PilihanKategori.equals("Elektronik")) {
            KategoriKertasDanKardus.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #16606D;\r\n" + //
                    "    -fx-border-color: #16606D;\r\n" + //
                    "    -fx-text-fill: #ffffff;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");
            SelectedKategori = KategoriKertasDanKardus;
        } else {
            KategoriPlastik.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #16606D;\r\n" + //
                    "    -fx-border-color: #16606D;\r\n" + //
                    "    -fx-text-fill: #ffffff;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");
            SelectedKategori = KategoriPlastik;
        }

    }

    void setIDBarang(int ID) {
        this.IDbarang = ID;
    }

    @FXML
    void Batal(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GraphicUserInterface/KatalogManagePage.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("SecondLife");
        stage.show();

        ((Parent) event.getSource()).getScene().getWindow().hide();

    }

    @FXML
    void Hapus(MouseEvent event) throws IOException {
        DB.ConnectToDataBase("src/SecondLifeDatabase.db");
        DB.Deletebarang(IDbarang);
        DB.DisconnectFromDataBase();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GraphicUserInterface/KatalogManagePage.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("SecondLife");
        stage.show();

        ((Parent) event.getSource()).getScene().getWindow().hide();

    }

    @FXML
    void KertasDanKardusPilih(MouseEvent event) {
        if (SelectedKategori != null) {
            SelectedKategori.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #ffffff;\r\n" + //
                    "    -fx-border-color: #000000;\r\n" + //
                    "    -fx-text-fill: #16606D;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");

            KategoriKertasDanKardus.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #16606D;\r\n" + //
                    "    -fx-border-color: #16606D;\r\n" + //
                    "    -fx-text-fill: #ffffff;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");
        } else {
            KategoriKertasDanKardus.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #16606D;\r\n" + //
                    "    -fx-border-color: #16606D;\r\n" + //
                    "    -fx-text-fill: #ffffff;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");
        }
        SelectedKategori = KategoriKertasDanKardus;
        PilihanKategori = KategoriKertasDanKardus.getText();
    }

    @FXML
    void PakaianDanTekstilPilih(MouseEvent event) {
        if (SelectedKategori != null) {
            SelectedKategori.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #ffffff;\r\n" + //
                    "    -fx-border-color: #000000;\r\n" + //
                    "    -fx-text-fill: #16606D;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");

            KategoriPakaianDanTekstil.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #16606D;\r\n" + //
                    "    -fx-border-color: #16606D;\r\n" + //
                    "    -fx-text-fill: #ffffff;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");

        } else {
            KategoriPakaianDanTekstil.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #16606D;\r\n" + //
                    "    -fx-border-color: #16606D;\r\n" + //
                    "    -fx-text-fill: #ffffff;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");

        }
        SelectedKategori = KategoriPakaianDanTekstil;
        PilihanKategori = KategoriPakaianDanTekstil.getText();

    }

    @FXML
    void GantiGambarBarang(MouseEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files (.png, .jpg)", "*.png", "*.jpg"));

        File imageFile = chooser.showOpenDialog(null);
        if (imageFile != null) {
            DataGambarBarang = new Image(imageFile.toPath().toString());
            GambarBarang.setImage(DataGambarBarang);
            DataGambarBarangSimpan = imageFile;
        }
    }

    @FXML
    void PlastikPilih(MouseEvent event) {
        if (SelectedKategori != null) {
            SelectedKategori.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #ffffff;\r\n" + //
                    "    -fx-border-color: #000000;\r\n" + //
                    "    -fx-text-fill: #16606D;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");

            KategoriPlastik.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #16606D;\r\n" + //
                    "    -fx-border-color: #16606D;\r\n" + //
                    "    -fx-text-fill: #ffffff;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");
        } else {
            KategoriPlastik.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #16606D;\r\n" + //
                    "    -fx-border-color: #16606D;\r\n" + //
                    "    -fx-text-fill: #ffffff;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");
        }
        SelectedKategori = KategoriPlastik;
        PilihanKategori = KategoriPlastik.getText();
    }

    @FXML
    void DekorasiDanAksesorisPilih(MouseEvent event) {
        if (SelectedKategori != null) {
            SelectedKategori.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #ffffff;\r\n" + //
                    "    -fx-border-color: #000000;\r\n" + //
                    "    -fx-text-fill: #16606D;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");

                    KategoriDekorasiDanAksesoris.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #16606D;\r\n" + //
                    "    -fx-border-color: #16606D;\r\n" + //
                    "    -fx-text-fill: #ffffff;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");
        } else {
            KategoriDekorasiDanAksesoris.setStyle("-fx-border-radius: 0;\r\n" + //
                    "    -fx-background-radius: 0;\r\n" + //
                    "    -fx-background-color: #16606D;\r\n" + //
                    "    -fx-border-color: #16606D;\r\n" + //
                    "    -fx-text-fill: #ffffff;\r\n" + //
                    "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0.2, 0, 2)");
        }
        SelectedKategori = KategoriDekorasiDanAksesoris;
        PilihanKategori = KategoriDekorasiDanAksesoris.getText();

    }

    @FXML
    void Edit(MouseEvent event) throws IOException, SQLException {
        DB.ConnectToDataBase("src/SecondLifeDatabase.db");

        boolean error = false;
        
        String NamaBarang = FieldNamaBarang.getText();
        String HargaBarang = FieldHargaBarang.getText();
        String KondisiBarang = PilihKondisi.getValue();
        String BrandBarang = FieldBrandBarang.getText();
        String UkuranBarang = FieldUkuranBarang.getText();
        String WarnaBarang = FieldWarnaBarang.getText();
        String KategoriBarang = PilihanKategori;
        String Deskripsi = FieldDeskripsi.getText();
        String PenjualBarang = session.getNama();
        File GambarBarang = DataGambarBarangSimpan;
        

        
            try{
                String x = HargaBarang.replace(".", "");
                int test = Integer.valueOf(x);
            }catch (Exception f){
                error = true;
            }
            if(error == false){

                
                
                if (NamaBarang == null || HargaBarang == null || KategoriBarang == null || KondisiBarang == null
                || BrandBarang == null || UkuranBarang == null || WarnaBarang == null) {
                    
                } else {
                    if (DataGambarBarangSimpan == null) {
                    System.out.println("Mengubah");
                    DB.UpdateBarang(IDbarang, NamaBarang, HargaBarang, PenjualBarang, KondisiBarang, UkuranBarang,
                    BrandBarang, WarnaBarang, KategoriBarang, Deskripsi);
                    
                } else {
                    System.out.println("Mengubah");
                    DB.UpdateBarang(IDbarang, NamaBarang, HargaBarang, PenjualBarang, KondisiBarang, UkuranBarang,
                    BrandBarang, WarnaBarang, KategoriBarang, Deskripsi, GambarBarang);
                    
                }
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GraphicUserInterface/KatalogManagePage.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = new Stage();
                
                stage.setScene(scene);
                stage.setResizable(false);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setTitle("SecondLife");
                stage.show();
                
                DB.DisconnectFromDataBase();
                ((Parent) event.getSource()).getScene().getWindow().hide();
            }
            
            
        }else{
            System.out.println("error angak");
        }

    }
}
