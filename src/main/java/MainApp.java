import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage stage) {
        Platform.setImplicitExit(false);
        this.primaryStage = stage;
        this.primaryStage.setTitle("Meats Meet Meat");
        this.primaryStage.setResizable(false);
        initializeScene();
    }

    private void initializeScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("FXML/Login.fxml"));
            Pane layout = (Pane) loader.load();
            Scene landingScene = new Scene(layout);
            primaryStage.setScene(landingScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

