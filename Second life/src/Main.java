
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
        primaryStage.setScene(new Scene(root, 1280,800));
        primaryStage.show();
        primaryStage.setResizable(true);
        
    }

    public static void main(String[] args) {

        launch(args);
    }
}
