package Controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

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

public class KatalogPageAddController implements Initializable {

    @FXML
    private Button BatalButton;

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
    private Button TambahButton;

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
        session = DataCurrentUser;
        DB.DisconnectFromDataBase();
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
            new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
    
        File imageFile = chooser.showOpenDialog(null);
        if (imageFile != null) {
            try {
                DataGambarBarang = new Image("file:" + imageFile.toPath().toString(), false); // Lazy loading
                GambarBarang.setImage(DataGambarBarang);
                DataGambarBarangSimpan = compressImage(imageFile);  // Compress image before saving
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private File compressImage(File originalFile) throws IOException {
    BufferedImage bufferedImage = ImageIO.read(originalFile);
    BufferedImage compressedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = compressedImage.createGraphics();
    g2d.drawImage(bufferedImage, 0, 0, null);
    g2d.dispose();

    File compressedFile = new File("compressed_" + originalFile.getName());
    ImageIO.write(compressedImage, "jpg", compressedFile);  // Save compressed image as JPEG
    return compressedFile;
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
    void TambahBarang(MouseEvent event) throws IOException {
        DB.ConnectToDataBase("src/SecondLifeDatabase.db");
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

        if(NamaBarang == null || HargaBarang == null || KategoriBarang == null || KondisiBarang == null|| BrandBarang == null|| UkuranBarang == null|| WarnaBarang == null){

        }else{
        try {
            DB.InsertBarang(NamaBarang,HargaBarang,PenjualBarang,KondisiBarang,UkuranBarang,BrandBarang,WarnaBarang,KategoriBarang,Deskripsi,GambarBarang, "Belum Terjual");
            DB.InsertBarangAdminVersion(NamaBarang,HargaBarang,PenjualBarang,KondisiBarang,UkuranBarang,BrandBarang,WarnaBarang,KategoriBarang,Deskripsi,GambarBarang, "Belum Terjual");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e);
        }
        DB.DisconnectFromDataBase();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GraphicUserInterface/KatalogManagePage.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("S");
        stage.show();

        ((Parent) event.getSource()).getScene().getWindow().hide();
        }

    }

}
